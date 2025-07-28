LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/ajdonich/spi-device-driver.git;protocol=ssh;branch=main"
SRCREV = "8494de2da248d386dc8619df0bf329f836bf9f86"
S = "${WORKDIR}/git"


FILES:${PN} += "${ROOT_HOME}/README.md"


python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*               spi-tft layer                 *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

addtask display_banner before do_install

do_install () {
    install -d ${D}${ROOT_HOME}
    install -m 0755 ${S}/README.md ${D}${ROOT_HOME}
}
