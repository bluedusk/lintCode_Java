package string;

/**
 * Created by Lenovo on 2017/10/13.
 */
public class SystemLongestFilePath {

    public static int lengthLongestPath(String input) {
        int result = 0;
        // 当前层级path的长度， path+文件 = 总长度；
        int[] path = new int[input.length() + 2];
        String[] st = input.split("\n");
        for (String line : st) {
            // replaceAll  \t
            String name = line.replaceAll("(\t)+", "");
            // 算出是几级目录,几个\t就几个目录
            int depth = line.length() - name.length();
            // 遇到文件算出总长，取最大；
            if(name.contains(".")) {
                result = Math.max(result, path[depth] + name.length());
            }
            // 如果是目录累加path
            else {
                path[depth + 1] = path[depth] + name.length() + 1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        String[] s = {};
        int[] A = {};
        int[][] AA = {};
        String str1 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

        lengthLongestPath(str1);


    }
}
