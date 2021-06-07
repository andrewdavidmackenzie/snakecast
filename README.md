Custom Chromecast Receiver
=

The main file that loads the custom receiver code on the chromecast is index.html.

That loads the chromecast Javascript library script 
(from http://www.gstatic.com/cast/sdk/libs/receiver/2.0.0/cast_receiver.js)
and then snake.js has the main logic of the game.

Local Development
==
For local development and testing, just open the file index.html in your chrome browser.

Remote Chromecast Debugging
==
TODO

Publishing / Hosting of the receiver code where a chromecast can download it
==
On merge of a PR to master, the travis job in ../.travis.yml will run, if it builds and 
passes, then the `deploy` will run. This uses Travis's Github Pages deployer to deploy
the contents of this folder (`receiver`) to https://andrewdavidmackenzie.github.io/snakecast

castReceiverController.js
==
This is the javascript library to talk over the chromecast channel to connected `sender` mobile apps
that connect there.