package strings;

public class StringMain {

    public void start() {
        String str;


        str = "Simba";
        System.out.println(str);

        str = str.toLowerCase();
        System.out.println(str);

        str = str.toUpperCase();
        System.out.println(str);

        str = "\t\r\nSimba the lion ";
        str = str.trim();
        System.out.println(str);

        str = "\tSimba the lion";
        str = str.strip();
        System.out.println(str);

        str = "Simba";
        str = str.concat(" the lion");
        System.out.println(str);

        str = "Simba Simba Simba";
        str = str.replaceFirst(" ",  "_");
        System.out.println(str);

        str = "Simba Simba Simba";
        str = str.replace(' ', '_');
        System.out.println(str);

        str = "Simba Simba Simba";
        str = str.replaceAll(" ", "_");
        System.out.println(str);

        str = "Simba Simba Simba";
        str = str.replaceAll("Simba", "_");
        System.out.println(str);

        str = "Simba the lion";
        str = str.substring(6);
        System.out.println(str);

        str = "Simba the lion";
        str = str.substring(str.indexOf("the"));
        System.out.println(str);

        str = "Simba the lion";
        str = str.substring(2, 7);
        System.out.println("|" + str + "|");

        str = "Simba";
        System.out.println(str.equals("simba"));

        str = "Simba the lion";
        System.out.println(str.contains("the"));

        str = "Simba the lion";
        System.out.println(str.charAt(0));

        str = "Simba the lion";
        System.out.println(str.length());

        str = "Simba the lion";
        System.out.println(str.split(" "));
    }
}
