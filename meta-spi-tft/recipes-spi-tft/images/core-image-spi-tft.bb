inherit core-image

IMAGE_INSTALL:append = " spi-tft" 
IMAGE_FEATURES:append = " ssh-server-openssh"
IMAGE_BOOT_FILES:append = " ilitft.dtbo;overlays/ilitft.dtbo"


inherit extrausers

# PASSWD = `printf "%q" $(mkpasswd -m sha256crypt root)` # i.e. hash of "root"
PASSWD = "\$5\$2WoxjAdaC2\$l4aj6Is.EWkD72Vt.byhM5qRtF9HcCM/5YpbxpmvNB5"
EXTRA_USERS_PARAMS = "usermod -p '${PASSWD}' root;"
