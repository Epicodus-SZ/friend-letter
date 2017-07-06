import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    // This sets the default location for files 
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";


    get("/", (request, response) -> {
      // spark create a hashmap named model
      Map<String, Object> model = new HashMap<String, Object>();
      //then puts the hello.vtl object into the hashmap, with the key of 'template'
      model.put("template", "templates/hello.vtl" );
      //this tells spark to return a new HTML file or ModelAndView, using the model hashmap(MODEL) and layout view
      //this prompts Spark to load our layout template
      // which triggers the #parse( $template )
      // The template word refers to the key in the hashmap, which returns the hello.vtl object in the hashmap
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/favorite_photos", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/favorite_photos.vtl" );
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}