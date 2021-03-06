package net.mackenzie.snakecast;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import net.mackenzie.chromeinteractor.ChromecastInteractor;

/**
 * Main activity of the application
 */
public class MainActivity extends AppCompatActivity {
    private SnakeController snakeController;
    private ChromecastInteractor chromecastInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        snakeController = new SnakeController(this);
        new SnakeControllerView(this, snakeController);
        chromecastInteractor = new ChromecastInteractor(this, getString(R.string.app_id), getString(R.string.namespace),
                snakeController);
    }

    @Override
    protected void onPause() {
        snakeController.pause();
        chromecastInteractor.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        chromecastInteractor.resume();
    }

    @Override
    public void onDestroy() {
        chromecastInteractor.disconnect();
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        // Ignore configuration changes - like rotation of th mobile device
    }

    /**
     * Add the MediaRoute ("Chromecast") button to the ActionBar at the top of the app
     *
     * @param menu - menu to add the menu items to
     * @return true if added an item
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        chromecastInteractor.setMediaRouteSelector(menu);
        return true;
    }
}
