package com.codecode.scriptenginemanager;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptEvaluator {
    public static void main(String[] args) throws ScriptException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("GraalVM ");
        engine.put("name","World");
        engine.eval("println('Hello,' + name");
    }
}
