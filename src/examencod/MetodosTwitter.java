package examencod;

import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author acarreiragonzalez
 */
public class MetodosTwitter {

    Twitter twitter;

    /**
     *
     */
    public MetodosTwitter() {

  ConfigurationBuilder cb = new ConfigurationBuilder();
cb.setDebugEnabled(true)
  .setOAuthConsumerKey("X0d6pd4qUcffIBYxpOXqO6O9S")
  .setOAuthConsumerSecret("AxBGWMgr5LfRJzNcdvvaeFInFjODSziXQ3BdMPjNVtXBAlT6hj")
  .setOAuthAccessToken("555179853-DaYe45ZS9YSrhhKsMijJJVoxdboAZzDKBtuCSIpT")
  .setOAuthAccessTokenSecret(" o2kznZfn8pD3qbo7gXPU0nMsdISD5yrMEwJR4ScTUKTB4");
TwitterFactory tf = new TwitterFactory(cb.build());
Twitter twitter = tf.getInstance();

    }

//Método que nos muestra la línea de tiempo

    /**
     *
     * @throws TwitterException
     */
        public void lineaTiempo() throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Mostrando línea de tiempo");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }

    }

//Método que nos busca un tweet  

    /**
     *
     * @param busqueda
     * @throws TwitterException
     */
        public void buscarString(String busqueda) throws TwitterException {

        Query query = new Query(busqueda);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }

    }

 //Método que nos pide un String y lo tweetea

    /**
     *
     * @param tweet
     * @throws TwitterException
     */
        public void tweetear(String tweet) throws TwitterException {

        Status status = twitter.updateStatus(tweet);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");

    }

}
