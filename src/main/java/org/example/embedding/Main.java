package org.example.embedding;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.nativeimage.c.function.CEntryPoint;

import java.io.*;
import java.util.Set;

public class Main {

    public static void main(String[] args){
        test();
    }

    private static void test(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/Users/gongyanan/tmp/index.md"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Context context = Context.newBuilder().allowAllAccess(true).build()) {
            Set<String> languages = context.getEngine().getLanguages().keySet();
            for (String id : languages) {
                context.initialize(id);
                if (id.equals("js")) {
                    context.eval("js", "function main(data) { console.log(data.readLine()); }");
                    Value funMain = context.getBindings("js").getMember("main");
                    funMain.execute(br);
                }
            }
        }
    }

    private static void test1() {
        try (Context context = Context.newBuilder().allowAllAccess(true).build()) {
            Set<String> languages = context.getEngine().getLanguages().keySet();
            for (String id : languages) {
                context.initialize(id);
                if (id.equals("js")) {
                    context.eval("js", "function main(data) { console.log(data.readLine()); }");
                    Value funMain = context.getBindings("js").getMember("main");
                    funMain.execute("123");
                }
            }
        }
    }

    @CEntryPoint(name = "function_name")
    static void add(IsolateThread thread) {
        test1();
    }
}
