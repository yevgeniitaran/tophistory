package com.yeta.tophistory.parser;

import net.openhft.compiler.CompilerUtils;
import org.springframework.stereotype.Service;

@Service
public class ParserCompiler  {

    public AbstractParser generate(String className, String javaCode) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode);
        return (AbstractParser) aClass.newInstance();
    }
}
