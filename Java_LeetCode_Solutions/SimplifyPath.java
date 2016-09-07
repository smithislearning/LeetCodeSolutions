public class Solution {
    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();
        char[] pathChars = path.toCharArray();
        try {
            if(pathChars[0] != '/') {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Please give me an absolute path.");
        }
        for(int i = 0; i < pathChars.length; i++) {
            if(i == 0) {
                result.append(pathChars[i]);
            } else if(i == pathChars.length - 1 && pathChars[i] == '/') {
                break;
            } else if(pathChars[i] == '/' && pathChars[i - 1] == '/') {
                continue;
            } else if(pathChars[i] == '.') {
                if(i == pathChars.length - 1 && pathChars[i - 1] == '/') {
                    break;
                } else if(i <= pathChars.length -2 && pathChars[i - 1] == '/' && pathChars[i + 1] == '/') {
                    if(i == pathChars.length - 2) {
                        break;
                    } else {
                        i += 1;
                        continue;
                    }
                } else if (i == pathChars.length - 2 && pathChars[i + 1] == '.' && pathChars[i - 1] == '/' ) {
                    if(result.length() > 1) {
                        result.deleteCharAt(result.length() - 1);
                        for(int j = result.length() - 1; ; j--) {
                            if(result.charAt(j) == '/') {
                                break;
                            } else {
                                result.deleteCharAt(j);
                            }
                        }
                    }
                    break;
                } else if(i <= pathChars.length -3 && pathChars[i + 1] == '.' && pathChars[i - 1] == '/' && pathChars[i + 2] == '/') {
                    if(result.length() > 1) {
                        result.deleteCharAt(result.length() - 1);
                        for(int j = result.length() - 1; ; j--) {
                            if(result.charAt(j) == '/') {
                                break;
                            } else {
                                result.deleteCharAt(j);
                            }
                        }
                    }
                    if(i == pathChars.length -3) {
                        break;
                    } else {
                        i += 2;
                        System.out.println(i);
                        continue;
                    }
                } else {
                    System.out.println(i);
                    result.append(pathChars[i]);
                }
            } else {
                result.append(pathChars[i]);
            }
        }
        if(result.length() > 1 && result.charAt(result.length() - 1) == '/') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
}