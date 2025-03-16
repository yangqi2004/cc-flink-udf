package io.confluent.flink.table.modules.remoteudf;
import org.apache.flink.table.functions.ScalarFunction;
import org.json.*;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

import java.io.IOException;
import java.util.List;


public class jsonJoltTransform extends ScalarFunction {
    public String eval(String jsonInput) throws IOException {

        // How to access the test artifacts, i.e. JSON files
        //  JsonUtils.classpathToList : assumes you put the test artifacts in your class path
        //  JsonUtils.filepathToList : you can use an absolute path to specify the files

        List chainrSpecJSON = JsonUtils.classpathToList( "/json/sample/spec.json" );
        Chainr chainr = Chainr.fromSpec( chainrSpecJSON );

        Object inputJSON = JsonUtils.jsonToObject( jsonInput );

        Object transformedOutput = chainr.transform( inputJSON );
        return JsonUtils.toJsonString( transformedOutput ) ;
    }



    public static void main(String[] args) {
        jsonJoltTransform retrieve = new  jsonJoltTransform();
        //System.out.println(retrieve.eval("<?xml version=\"1.0\" ?><root><test attribute=\"text1\">javatpoint</test><test attribute=\"text2\">JTP</test></root>"));
    }
}


