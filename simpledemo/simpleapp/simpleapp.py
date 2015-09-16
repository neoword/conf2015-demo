import logging
from logging.handlers import RotatingFileHandler
import time
from flask import Flask


LOG_FILENAME = "/usr/local/apps/sampleapp/logs/stdout.log"
LOG_ROTATE_SIZE = 10485760

# Declare Logger
logger = logging.getLogger('logload')
logger.setLevel(logging.DEBUG)

# Set the formatter in the log message handler
# Add the handler to the logger
handler = RotatingFileHandler(LOG_FILENAME, maxBytes=LOG_ROTATE_SIZE, backupCount=5)
handler.setFormatter(logging.Formatter(fmt='[%(asctime)s] - %(name)s - %(levelname)s - %(message)s',))
logger.addHandler(handler)

# declare our flask app
app = Flask(__name__)

# health check
@app.route("/health")
def health():
    return "up"

# log some stuff
@app.route("/logShakespeare")
def log_shakespeare():
    """Lets log some shakespeare"""

    # read the file into memory
    lines = open('shakespeare.txt').read().split('\n')

    # Do this 6 times...
    for j in range(0,6):
        
        # log 8192 lines...
        for i in range(0, 8192):
            logger.debug("%s,%s:%s" % (j,i,lines[i]));
            
        # ...every 10 seconds
        time.sleep(10)
    return "done"

if __name__ == "__main__":
    app.run(host='0.0.0.0')
