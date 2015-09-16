import logging
from logging.handlers import RotatingFileHandler
import time

LOG_FILENAME = "/var/log/sampleapp/logs/stdout.log"

def start():
    """Starting log load"""
    logger = logging.getLogger('logload')
    logger.setLevel(logging.DEBUG)

    # Add the formatter
    # Add the log message handler to the logger
    handler = RotatingFileHandler(LOG_FILENAME, maxBytes=10024000, backupCount=5)
    formatter = logging.Formatter(fmt='[%(asctime)s] - %(name)s - %(levelname)s - %(message)s',)
    handler.setFormatter(formatter)
    logger.addHandler(handler)

    # read the file into memory
    lines = open('shakespeare.txt').read().split('\n')

    # Do this 6 times...
    for j in range(0,6):
        
        # log 8192 lines...
        for i in range(0, 8192):
            logger.debug("%s,%s:%s" % (j,i,lines[i]));
            
        # ...every 10 seconds
        time.sleep(10)
        

if __name__=='__main__':
    start()


