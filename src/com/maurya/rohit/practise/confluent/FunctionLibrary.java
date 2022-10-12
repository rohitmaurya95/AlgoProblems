package com.maurya.rohit.practise.confluent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//public class FunctionLibrary {
//    FunctionNode root;
//    public FunctionLibrary() {
//        root = new FunctionNode(null);
//    }
//
//    static class Function {
//        String name;
//        List<String> argumentTypes;
//        boolean isVariadic;
//
//        Function(String name, List<String> argumentTypes, boolean isVariadic) {
//            this.name = name;
//            this.argumentTypes = argumentTypes;
//            this.isVariadic = isVariadic;
//        }
//
//        @Override
//        public String toString() {
//            return name;
//        }
//    }
//    class FunctionNode {
//        String type;
//        Map<String, FunctionNode> next = new HashMap<>();
//        boolean isVariable;
//        FunctionNode varNext;
//        List<Function> functions = new ArrayList<>();
//        public FunctionNode(String type) {
//            this.type = type;
//        }
//    }
//    public void register(Set<Function> functionSet)  {
//        for (Function function: functionSet){
//            FunctionNode current = root;
//            for (String type: function.argumentTypes){
//                current.next.putIfAbsent(type, new FunctionNode(type));
//                current = current.next.get(type);
//            }
//
//            current.functions.add(function);
//
//            if(function.isVariadic){
//                current.isVariable = true;
//                FunctionNode var = new FunctionNode(current.type);
//                var.functions.add(function);
//                var.next.put(current.type, var);
//                current.varNext = var;
//            }
//
//        }
//        // implement this method.
//    }
//
//    public List<Function> findMatches(List<String> argumentTypes) {
//        List<Function> matches = new ArrayList<>();
//
//        return null;
//    }
//
//    public void findMatches (FunctionNode current, List<String> argumentsType, int idx, List<Function> matches){
//        if(current==null){
//            return;
//        }
//
//        if(idx==argumentsType.size()){
//            matches.addAll(current.functions);
//        }
//
//        String type = argumentsType.get(idx);
//        findMatches(current.next.get(type), argumentsType, idx+1, matches);
//        if(current.isVariable && current.type.equals(type)){
//            findMatches(current.varNext, argumentsType, idx+1, matches);
//        }
//    }
//
//    public static void main(String[] args) {
//        FunctionLibrary lib = new FunctionLibrary();
//        Set<Function> fns = new HashSet<>();
//        fns.add(new Function("FuncA", Arrays.asList("String", "Integer", "Integer"), false));
//        fns.add(new Function("FuncB", Arrays.asList("String", "Integer"), true));
//        fns.add(new Function("FuncC", Arrays.asList("Integer"), true));
//        fns.add(new Function("FuncD", Arrays.asList("Integer", "Integer"), true));
//        fns.add(new Function("FuncE", Arrays.asList("Integer", "Integer", "Integer"), false));
//        fns.add(new Function("FuncF", Arrays.asList("String"), false));
//        fns.add(new Function("FuncG", Arrays.asList("Integer"), false));
//        lib.register(fns);
//        System.out.println(lib.findMatches(Arrays.asList("String")));
//        System.out.println(lib.findMatches(Arrays.asList("Integer")));
//        System.out.println(lib.findMatches(Arrays.asList("Integer", "Integer", "Integer", "Integer")));
//        System.out.println(lib.findMatches(Arrays.asList("Integer", "Integer", "Integer")));
//        System.out.println(lib.findMatches(Arrays.asList("String", "Integer", "Integer", "Integer")));
//        System.out.println(lib.findMatches(Arrays.asList("String", "Integer", "Integer")));
//    }
//}

class Function {
    String name;
    List<String> argumentTypes;
    boolean isVariadic;

    Function(String name, List<String> argumentTypes, boolean isVariadic) {
        this.name = name;
        this.argumentTypes = argumentTypes;
        this.isVariadic = isVariadic;
    }

    @Override
    public String toString() {
        return name;
    }
}

class FunctionNode {
    String type;
    Map<String, FunctionNode> next = new HashMap<>();
    boolean variadic = false;
    FunctionNode variadicEdge = null;
    List<Function> functions = new ArrayList<>();
    FunctionNode(String type) {
        this.type = type;
    }
}

class FunctionLibrary {
    FunctionNode root = new FunctionNode(null);

    public void register(Set<Function> functionSet) {
        for(Function function : functionSet) {
            FunctionNode at = root;
            for(String type : function.argumentTypes) {
                at.next.putIfAbsent(type, new FunctionNode(type));
                FunctionNode next = at.next.get(type);
                at = next;
            }
            at.functions.add(function);
            if(function.isVariadic) {
                at.variadic = true;
                FunctionNode varNode = new FunctionNode(at.type);
                at.variadicEdge = varNode;
                varNode.functions.add(function);
                varNode.next.put(at.type, varNode);
            }
        }
    }

    public List<Function> findMatches(List<String> argumentTypes) {
        List<Function> matched = new ArrayList<>();
        findMatches(root, argumentTypes, 0, matched);
        return matched;
    }

    public void findMatches(FunctionNode at, List<String> argumentTypes, int idx, List<Function> matched) {
        if(at == null) {
            return;
        }
        if(idx == argumentTypes.size()) {
            matched.addAll(at.functions);
            return;
        }
        String type = argumentTypes.get(idx);
        findMatches(at.next.get(type), argumentTypes, idx+1, matched);
        if(at.variadic && type.equals(at.type)) {
            findMatches(at.variadicEdge, argumentTypes, idx+1, matched);
        }
    }

}

class MatchFunctions {
    public static void main(String[] args) {
        FunctionLibrary lib = new FunctionLibrary();
        Set<Function> fns = new HashSet<>();
        fns.add(new Function("FuncA", Arrays.asList("String", "Integer", "Integer"), false));
        fns.add(new Function("FuncB", Arrays.asList("String", "Integer"), true));
        fns.add(new Function("FuncC", Arrays.asList("Integer"), true));
        fns.add(new Function("FuncD", Arrays.asList("Integer", "Integer"), true));
        fns.add(new Function("FuncE", Arrays.asList("Integer", "Integer", "Integer"), false));
        fns.add(new Function("FuncF", Arrays.asList("String"), false));
        fns.add(new Function("FuncG", Arrays.asList("Integer"), false));
        lib.register(fns);
        System.out.println(lib.findMatches(Arrays.asList("String")));
        System.out.println(lib.findMatches(Arrays.asList("Integer")));
        System.out.println(lib.findMatches(Arrays.asList("Integer", "Integer", "Integer", "Integer")));
        System.out.println(lib.findMatches(Arrays.asList("Integer", "Integer", "Integer")));
        System.out.println(lib.findMatches(Arrays.asList("String", "Integer", "Integer", "Integer")));
        System.out.println(lib.findMatches(Arrays.asList("String", "Integer", "Integer")));
    }
}
