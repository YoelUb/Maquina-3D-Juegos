package com.maquina3djuegos.command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    private final List<Command> history = new ArrayList<>();

    public String invoke(Command cmd) {
        String result = cmd.execute();
        history.add(cmd);
        return result;
    }
}
