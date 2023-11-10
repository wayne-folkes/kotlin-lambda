package example
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import software.amazon.lambda.powertools.logging.Logging

class Handler : RequestHandler<Map<String,String>, String> {

    companion object {
        val logger: Logger = LogManager.getLogger(Handler::class.java)
    }
    @Logging(logEvent = true)
    override fun handleRequest(input: Map<String,String>, context: Context): String {
        logger.info("Hello, ${input["firstName"]} ${input["lastName"]}")
        return "Hello";
    }


}
