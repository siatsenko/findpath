package com.siatsenko;

public class FindPathApp {

    public static void main(String[] args) {
        String path;
        if (args.length > 0) {
            path = new FindPathInputReaderFile(args[0]).findPath();
        } else {
            path = new FindPathInputReaderStdIn().findPath();
        }
        System.out.println(path);
    }

}
