package com.siatsenko;

import java.io.Reader;

public abstract class AbstractFindPathInputReader {

    abstract Reader getReader();

    public String findPath() {
        InputHandler inputHandler = new InputHandler(getReader());
        PrepareHandler prepareHandler = new PrepareHandler(inputHandler.getFromReader());
        PathHandler pathHandler = new PathHandler(prepareHandler.getNodes());
        return pathHandler.findPath();
    }

}
