import com.avaje.ebean.Ebean;
import play.*;
import java.util.*;

import models.*;
import play.libs.Yaml;

public class Global extends GlobalSettings {
    @Override
    public void onStart(Application application) {
        super.onStart(application);

        if(User.find.findRowCount() == 0) {
            Logger.info("Loading initial data");
            try {
                Map<String,List<Object>> all = (Map<String,List<Object>>) Yaml.load("initial-data.yml");
                List<Object> users = all.get("users");
                Ebean.save(users);
                Logger.info("Loaded " + users.size() + " users from initial data");
            } catch (ClassCastException e) {
                Logger.error("Cannot load initial data: incorrect file format.", e);
            }
        }
    }
}
