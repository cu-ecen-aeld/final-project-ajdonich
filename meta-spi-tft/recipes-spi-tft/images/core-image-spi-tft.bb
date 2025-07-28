inherit core-image
inherit extrausers

IMAGE_INSTALL:append = " spi-tft" 
IMAGE_INSTALL:append = " openssh"


# PASSWD = `printf "%q" $(mkpasswd -m sha256crypt root)` # i.e. hash of "root"
PASSWD = "\$5\$2WoxjAdaC2\$l4aj6Is.EWkD72Vt.byhM5qRtF9HcCM/5YpbxpmvNB5"
EXTRA_USERS_PARAMS = "usermod -p '${PASSWD}' root;"
