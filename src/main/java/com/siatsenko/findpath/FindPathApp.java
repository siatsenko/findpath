package com.siatsenko.findpath;

import com.siatsenko.findpath.input.InputReaderFile;
import com.siatsenko.findpath.input.InputReaderStdIn;
import com.siatsenko.findpath.prepare.PrepareHandler;
import com.siatsenko.findpath.processing.PathHandler;

import java.util.List;

public class FindPathApp {

    public static void main(String[] args) {
        String path;
        List<String> strings;
        if (args.length > 0) {
            strings = new InputReaderFile(args[0]).getStrings();
        } else {
            strings = new InputReaderStdIn().getStrings();
        }

        PrepareHandler prepareHandler = new PrepareHandler(strings);
        PathHandler pathHandler = new PathHandler(prepareHandler.getNodes());
        path = pathHandler.findPath();
        System.out.println(path);
    }

}
