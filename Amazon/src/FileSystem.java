import java.io.File;
import java.util.*;
import java.util.Collections;
import java.util.List;

public class FileSystem {
    class Dir {
        Map<String, Dir> directory;
        Map<String, String> file;
    }

    Dir root;
    public FileSystem() {
        root = new Dir();
    }

    //ls: Given a path in string format. If it is a file path,
    // return a list that only contains this file's name. If it is a directory path,
    // return the list of file and directory names in this directory.
    // Your output (file and directory names together) should in lexicographic order.
    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        Dir curr = root;
        if(!path.equals("/")){
            String[] d = path.split("/");
            for(int i = 0;i<d.length-1;i++){
                curr = curr.directory.get(d[i]);
            }
            if(curr.file.containsKey(d[d.length-1])){
                result.add(d[d.length-1]);
                return result;
            }else{
                curr = curr.directory.get(d[d.length-1]);
            }
        }
        result.addAll(new ArrayList<>(curr.directory.keySet()));
        result.addAll(new ArrayList<>(curr.file.keySet()));
        Collections.sort(result);
        return result;
    }

//    //mkdir: Given a directory path that does not exist,
//    // you should make a new directory according to the path.
//    // If the middle directories in the path don't exist either,
//    // you should create them as well. This function has void return type.
//    public void mkdir(String path) {
//
//    }
//
//    //addContentToFile: Given a file path and file content in string format.
//    // If the file doesn't exist, you need to create that file containing given content.
//    // If the file already exists, you need to append given content to original content.
//    // This function has void return type.
//    public void addContentToFile(String filePath, String content) {
//
//    }
//
//    //readContentFromFile: Given a file path, return its content in string format.
//    public String readContentFromFile(String filePath) {
//
//    }
}
