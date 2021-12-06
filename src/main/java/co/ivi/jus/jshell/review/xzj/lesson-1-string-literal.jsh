boolean isSameString(String s1, String s2) {
    return s1 == s2;
}
System.out.println("isSameString(\"j\", \"j\") => " + isSameString("j", "j"));
System.out.println("isSameString(\"j\", new String(\"j\")) => " + isSameString("j", new String("j")));
