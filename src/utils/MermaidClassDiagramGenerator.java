package utils;

import java.awt.*;
import java.awt.datatransfer.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;

/**
 * Utility class to generate Mermaid class diagram code from Java classes using reflection.
 * Handles interfaces, abstract classes, inheritance, method overrides, fields, and more.
 *
 * Note: To get real parameter names, compile your classes with: javac -parameters *.java
 */
public class MermaidClassDiagramGenerator {

    private static final Set<Class<?>> processedClasses = new HashSet<>();
    private static final Set<String> relationships = new LinkedHashSet<>();
    private static final Map<Class<?>, List<String>> classDefinitions = new LinkedHashMap<>();

    /**
     * Configuration options for diagram generation.
     */
    public static class Options {
        private boolean showLegend = false;
        private boolean includeConstructors = true;
        private boolean includeParameters = true;
        private boolean includeGettersSetters = true;
        private boolean includeFields = true;

        public Options() {}

        public Options showLegend(boolean value) {
            this.showLegend = value;
            return this;
        }

        public Options includeConstructors(boolean value) {
            this.includeConstructors = value;
            return this;
        }

        public Options includeParameters(boolean value) {
            this.includeParameters = value;
            return this;
        }

        public Options includeGettersSetters(boolean value) {
            this.includeGettersSetters = value;
            return this;
        }

        public Options includeFields(boolean value) {
            this.includeFields = value;
            return this;
        }

        // Getters
        public boolean isShowLegend() { return showLegend; }
        public boolean isIncludeConstructors() { return includeConstructors; }
        public boolean isIncludeParameters() { return includeParameters; }
        public boolean isIncludeGettersSetters() { return includeGettersSetters; }
        public boolean isIncludeFields() { return includeFields; }
    }

    // Current options (thread-local for safety)
    private static Options currentOptions = new Options();

    /**
     * Generates Mermaid class diagram code for the given classes.
     * Automatically copies the result to clipboard.
     *
     * @param classes The classes to include in the diagram
     * @return Mermaid markdown string representing the class diagram
     */
    public static String generateForClasses(Class<?>... classes) {
        return generateForClasses(new Options(), classes);
    }

    /**
     * Generates Mermaid class diagram code for the given classes.
     * Automatically copies the result to clipboard.
     *
     * @param showLegend Whether to include a legend box explaining symbols
     * @param classes The classes to include in the diagram
     * @return Mermaid markdown string representing the class diagram
     */
    public static String generateForClasses(boolean showLegend, Class<?>... classes) {
        return generateForClasses(new Options().showLegend(showLegend), classes);
    }

    /**
     * Generates Mermaid class diagram code for the given classes with custom options.
     * Automatically copies the result to clipboard.
     *
     * @param options Configuration options for the diagram
     * @param classes The classes to include in the diagram
     * @return Mermaid markdown string representing the class diagram
     */
    public static String generateForClasses(Options options, Class<?>... classes) {
        // Clear previous state
        processedClasses.clear();
        relationships.clear();
        classDefinitions.clear();
        currentOptions = options;

        Set<Class<?>> targetClasses = new HashSet<>(Arrays.asList(classes));

        // Process each class
        for (Class<?> clazz : classes) {
            processClass(clazz, targetClasses);
        }

        // Build the Mermaid output
        StringBuilder sb = new StringBuilder();
        sb.append("classDiagram\n");

        // Add legend if requested
        if (options.isShowLegend()) {
            sb.append(generateLegend());
        }

        // Sort classes: interfaces first, then abstract classes, then concrete classes
        List<Class<?>> sortedClasses = new ArrayList<>(classDefinitions.keySet());
        sortedClasses.sort((a, b) -> {
            int scoreA = getClassTypeOrder(a);
            int scoreB = getClassTypeOrder(b);
            if (scoreA != scoreB) {
                return scoreA - scoreB;
            }
            return a.getSimpleName().compareTo(b.getSimpleName());
        });

        // Add class definitions
        for (Class<?> clazz : sortedClasses) {
            List<String> members = classDefinitions.get(clazz);

            sb.append("    class ").append(clazz.getSimpleName());

            if (members.isEmpty()) {
                sb.append("\n");
            } else {
                sb.append(" {\n");
                for (String member : members) {
                    sb.append("        ").append(member).append("\n");
                }
                sb.append("    }\n");
            }

            // Add stereotypes (abstract, interface, final)
            if (clazz.isInterface()) {
                sb.append("    <<interface>> ").append(clazz.getSimpleName()).append("\n");
            } else if (Modifier.isAbstract(clazz.getModifiers())) {
                sb.append("    <<abstract>> ").append(clazz.getSimpleName()).append("\n");
            } else if (Modifier.isFinal(clazz.getModifiers())) {
                sb.append("    <<final>> ").append(clazz.getSimpleName()).append("\n");
            }
        }

        sb.append("\n");

        // Add relationships
        for (String relationship : relationships) {
            sb.append("    ").append(relationship).append("\n");
        }

        String result = sb.toString();

        // Copy to clipboard
        copyToClipboard(result);

        return result;
    }

    /**
     * Copies the given text to the system clipboard.
     */
    private static void copyToClipboard(String text) {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection selection = new StringSelection(text);
            clipboard.setContents(selection, selection);
            System.out.println("✓ Mermaid diagram copied to clipboard!");
        } catch (HeadlessException e) {
            System.out.println("⚠ Could not copy to clipboard (headless environment)");
        } catch (Exception e) {
            System.out.println("⚠ Could not copy to clipboard: " + e.getMessage());
        }
    }

    /**
     * Generates a legend box explaining the symbols used in the diagram.
     */
    private static String generateLegend() {
        StringBuilder sb = new StringBuilder();
        sb.append("    class Legend {\n");
        sb.append("        +public\n");
        sb.append("        -private\n");
        sb.append("        #protected\n");
        sb.append("        ~package\n");
        sb.append("        $ static\n");
        sb.append("        * abstract\n");
        sb.append("        «override»\n");
        sb.append("        «final»\n");
        sb.append("        «constructor»\n");
        sb.append("    }\n");
        sb.append("    note for Legend \"UML Symbols Legend\"\n");
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Returns order priority: 0 = interface, 1 = abstract class, 2 = concrete class
     */
    private static int getClassTypeOrder(Class<?> clazz) {
        if (clazz.isInterface()) {
            return 0;
        } else if (Modifier.isAbstract(clazz.getModifiers())) {
            return 1;
        } else {
            return 2;
        }
    }

    private static void processClass(Class<?> clazz, Set<Class<?>> targetClasses) {
        if (processedClasses.contains(clazz) || clazz == Object.class) {
            return;
        }
        processedClasses.add(clazz);

        // Separate lists for ordering
        List<String> fields = new ArrayList<>();
        List<String> constructors = new ArrayList<>();
        List<String> gettersSetters = new ArrayList<>();
        List<String> otherMethods = new ArrayList<>();

        // Get declared fields
        if (currentOptions.isIncludeFields()) {
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isSynthetic()) {
                    continue;
                }
                fields.add(formatField(field));
            }
        }

        // Get declared methods
        Set<String> overriddenMethods = getOverriddenMethods(clazz);

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isSynthetic() || method.isBridge()) {
                continue;
            }
            String formatted = formatMethod(method, overriddenMethods);

            // Categorize method
            if (isGetterOrSetter(method)) {
                if (currentOptions.isIncludeGettersSetters()) {
                    gettersSetters.add(formatted);
                }
            } else {
                otherMethods.add(formatted);
            }
        }

        // Get constructors
        if (currentOptions.isIncludeConstructors()) {
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                if (constructor.isSynthetic()) {
                    continue;
                }
                constructors.add(formatConstructor(constructor, clazz));
            }
        }

        // Combine in order: fields, constructors, getters/setters, other methods
        List<String> members = new ArrayList<>();
        members.addAll(fields);
        members.addAll(constructors);
        members.addAll(gettersSetters);
        members.addAll(otherMethods);

        classDefinitions.put(clazz, members);

        // Process inheritance (extends)
        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null && superclass != Object.class) {
            if (targetClasses.contains(superclass)) {
                relationships.add(superclass.getSimpleName() + " <|-- " + clazz.getSimpleName());
            }
        }

        // Process interfaces (implements)
        for (Class<?> iface : clazz.getInterfaces()) {
            if (targetClasses.contains(iface)) {
                relationships.add(iface.getSimpleName() + " <|.. " + clazz.getSimpleName());
            }
        }
    }

    /**
     * Checks if a method is a getter or setter.
     */
    private static boolean isGetterOrSetter(Method method) {
        String name = method.getName();

        // Getter: getName(), isActive(), hasValue()
        if ((name.startsWith("get") || name.startsWith("is") || name.startsWith("has"))
                && method.getParameterCount() == 0
                && method.getReturnType() != void.class) {
            return true;
        }

        // Setter: setName(value)
        if (name.startsWith("set")
                && method.getParameterCount() == 1
                && method.getReturnType() == void.class) {
            return true;
        }

        return false;
    }

    private static Set<String> getOverriddenMethods(Class<?> clazz) {
        Set<String> overridden = new HashSet<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isSynthetic() || method.isBridge()) {
                continue;
            }

            if (isOverriding(clazz, method)) {
                overridden.add(getMethodSignature(method));
            }
        }

        return overridden;
    }

    private static boolean isOverriding(Class<?> clazz, Method method) {
        if (method.isAnnotationPresent(Override.class)) {
            return true;
        }

        // Check all superclasses (including non-public methods)
        Class<?> current = clazz.getSuperclass();
        while (current != null && current != Object.class) {
            try {
                // Use getDeclaredMethod to find non-public methods too
                Method superMethod = current.getDeclaredMethod(method.getName(), method.getParameterTypes());
                if (superMethod != null) {
                    return true;
                }
            } catch (NoSuchMethodException ignored) {
            }
            current = current.getSuperclass();
        }

        // Check interfaces
        for (Class<?> iface : getAllInterfaces(clazz)) {
            try {
                Method ifaceMethod = iface.getDeclaredMethod(method.getName(), method.getParameterTypes());
                if (ifaceMethod != null) {
                    return true;
                }
            } catch (NoSuchMethodException ignored) {
            }
        }

        return false;
    }

    private static Set<Class<?>> getAllInterfaces(Class<?> clazz) {
        Set<Class<?>> interfaces = new HashSet<>();

        interfaces.addAll(Arrays.asList(clazz.getInterfaces()));

        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null && superclass != Object.class) {
            interfaces.addAll(getAllInterfaces(superclass));
        }

        for (Class<?> iface : clazz.getInterfaces()) {
            interfaces.addAll(getAllInterfaces(iface));
        }

        return interfaces;
    }

    private static String getMethodSignature(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName()).append("(");
        Class<?>[] params = method.getParameterTypes();
        for (int i = 0; i < params.length; i++) {
            if (i > 0) sb.append(",");
            sb.append(params[i].getSimpleName());
        }
        sb.append(")");
        return sb.toString();
    }

    private static String formatField(Field field) {
        StringBuilder sb = new StringBuilder();

        sb.append(getVisibilitySymbol(field.getModifiers()));

        if (Modifier.isStatic(field.getModifiers())) {
            sb.append("$ ");
        }

        sb.append(field.getName()).append(" : ").append(formatType(field.getType()));

        // Add final marker
        if (Modifier.isFinal(field.getModifiers())) {
            sb.append(" «final»");
        }

        return sb.toString();
    }

    private static String formatMethod(Method method, Set<String> overriddenMethods) {
        StringBuilder sb = new StringBuilder();

        sb.append(getVisibilitySymbol(method.getModifiers()));

        if (Modifier.isStatic(method.getModifiers())) {
            sb.append("$ ");
        }

        if (Modifier.isAbstract(method.getModifiers())) {
            sb.append("* ");
        }

        sb.append(method.getName()).append("(");

        // Parameters with real names (if enabled)
        if (currentOptions.isIncludeParameters()) {
            Parameter[] params = method.getParameters();
            for (int i = 0; i < params.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append(getParameterName(params[i], i)).append(" : ").append(formatType(params[i].getType()));
            }
        }
        sb.append(")");

        if (method.getReturnType() != void.class) {
            sb.append(" : ").append(formatType(method.getReturnType()));
        }

        // Add modifiers
        String signature = getMethodSignature(method);
        if (overriddenMethods.contains(signature)) {
            sb.append(" «override»");
        }
        if (Modifier.isFinal(method.getModifiers())) {
            sb.append(" «final»");
        }

        return sb.toString();
    }

    private static String formatConstructor(Constructor<?> constructor, Class<?> clazz) {
        StringBuilder sb = new StringBuilder();

        sb.append(getVisibilitySymbol(constructor.getModifiers()));

        sb.append("«constructor» ").append(clazz.getSimpleName()).append("(");

        // Parameters with real names (if enabled)
        if (currentOptions.isIncludeParameters()) {
            Parameter[] params = constructor.getParameters();
            for (int i = 0; i < params.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append(getParameterName(params[i], i)).append(" : ").append(formatType(params[i].getType()));
            }
        }
        sb.append(")");

        return sb.toString();
    }

    /**
     * Gets the parameter name. If compiled with -parameters flag, returns the real name.
     * Otherwise, uses indexed naming (arg0, arg1, etc.).
     */
    private static String getParameterName(Parameter param, int index) {
        // If compiled with -parameters, use the real name
        if (param.isNamePresent()) {
            return param.getName();
        }

        // Otherwise, use simple indexed naming
        return "arg" + index;
    }

    private static String getVisibilitySymbol(int modifiers) {
        if (Modifier.isPublic(modifiers)) {
            return "+";
        } else if (Modifier.isPrivate(modifiers)) {
            return "-";
        } else if (Modifier.isProtected(modifiers)) {
            return "#";
        } else {
            return "~";
        }
    }

    private static String formatType(Class<?> type) {
        if (type.isArray()) {
            return formatType(type.getComponentType()) + "[]";
        }
        return type.getSimpleName();
    }

    /**
     * Alternative version that generates a simpler diagram without constructors.
     * Also copies to clipboard.
     */
    public static String generateSimplified(Class<?>... classes) {
        return generateForClasses(
                new Options()
                        .includeConstructors(false)
                        .includeParameters(false),
                classes
        );
    }

    /**
     * Alternative version that generates a simpler diagram without constructors.
     * Also copies to clipboard.
     *
     * @param showLegend Whether to include a legend box explaining symbols
     * @param classes The classes to include in the diagram
     */
    public static String generateSimplified(boolean showLegend, Class<?>... classes) {
        return generateForClasses(
                new Options()
                        .showLegend(showLegend)
                        .includeConstructors(false)
                        .includeParameters(false),
                classes
        );
    }

}