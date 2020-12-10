package soa.eip;

import org.apache.camel.Exchange;

public class maxProcess implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String inBody = exchange.getIn().getBody(String.class);
        String max = "10"; // default retrieved tweets

        String[] splittedInBody = inBody.split("max:");
        //by default the whole thing is the body
        String outBody = inBody;
        for(String s: splittedInBody){
            System.out.println("SPLITTED IN BODY: " + s);
        }

        if(splittedInBody.length > 1 && splittedInBody[1]!=null){
            System.out.println("IF BODY: " + splittedInBody[1]);
            max = splittedInBody[1].split(" ")[0]; //once it finds the full number the rest is ignored
            outBody = splittedInBody[0];
        }
        outBody += "?count=" + max;

        System.out.println("OUT BOYD PARSED: " + outBody);
        exchange.getIn().setBody(outBody);

    }
}
