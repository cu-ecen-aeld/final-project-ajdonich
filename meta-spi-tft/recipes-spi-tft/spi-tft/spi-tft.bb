inherit devicetree

COMPATIBLE_MACHINE = "^(raspberrypi4|raspberrypi4-64)$"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"

SRC_URI = "git://git@github.com/ajdonich/spi-device-driver.git;protocol=ssh;branch=main"
SRCREV = "8494de2da248d386dc8619df0bf329f836bf9f86"
S = "${WORKDIR}/git"

DT_FILES_PATH = "${S}/devicetree"
FILES:${PN}:append = " ${ROOT_HOME}/README.md"

do_preclean_devicetree () {
    rm ${S}/ilitft.dtbo ${S}/ilitft.dtso.pp
}

addtask preclean_devicetree before do_compile

do_install () {
    install -d ${D}${ROOT_HOME}
    install -m 0644 ${S}/README.md ${D}${ROOT_HOME}
}

