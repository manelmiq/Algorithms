//package examples.questions;
//
//import com.sun.xml.internal.bind.api.Bridge;
//import com.sun.xml.internal.ws.api.model.CheckedException;
//import com.sun.xml.internal.ws.api.model.ExceptionType;
//import com.sun.xml.internal.ws.api.model.JavaMethod;
//import com.sun.xml.internal.ws.api.model.SEIModel;
//
//import java.util.Optional;
//
//public class JavaClass {
//
//}
//
//class MyExecpetion extends Exception{
//    public String getReason() throws Exception{
//        throw new Exception();
//    }
//}
//
//
//class MyExecpetion2 extends RuntimeException{
//    public String getReason() throws Exception{
//        throw new Exception();
//    }
//
//    public MyExecpetion2(String s) {
//        super(s);
//    }
//}
//
//
//class MyExecpetion3 implements CheckedException {
//    final Optional<String> reason;
//
//    MyExecpetion3() {
//        super();
//        this.reason =  Optional.empty();
//    }
//    MyExecpetion3(String s) {
//        super(s);
//        this.reason =  Optional.ofNullable(s);
//    }
//
//
//
//    @Override
//    public SEIModel getOwner() {
//        return null;
//    }
//
//    @Override
//    public JavaMethod getParent() {
//        return null;
//    }
//
//    @Override
//    public Class getExceptionClass() {
//        return null;
//    }
//
//    @Override
//    public Class getDetailBean() {
//        return null;
//    }
//
//    @Override
//    public Bridge getBridge() {
//        return null;
//    }
//
//    @Override
//    public ExceptionType getExceptionType() {
//        return null;
//    }
//
//    @Override
//    public String getMessageName() {
//        return null;
//    }
//}
