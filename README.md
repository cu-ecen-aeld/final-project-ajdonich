# final-project-ajdonich

Yocto build repo for ECEA 5307 Final Project, see: [Project Overview Wiki](https://github.com/cu-ecen-aeld/final-project-ajdonich/wiki). All command sequences below assume PWD starts at repo root.

## Init

Init only needed once after first repo clone. If host has not been setup:

```bash
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install build-essential chrpath cpio debianutils diffstat file gawk gcc git iputils-ping libacl1 locales python3 python3-git python3-jinja2 python3-pexpect python3-pip python3-subunit socat texinfo unzip wget xz-utils zstd
```

This will clone/update the poky and meta-raspberrypi submodules, initialize the build environment, create the build config files from poky template versions, and then overwrite them with the base versions from this repo's root:

```bash
git submodule update --init --recursive

cd poky
source oe-init-build-env # Creates local.conf and local.conf in build/conf
cp ../../local.conf.base conf/local.conf # Overwrite with base file
cp ../../bblayers.conf.base conf/bblayers.conf # Overwrite with base file
```

## Build

This will kick off the full Yocto build (multi-hour if this is first build). Note: first go to bottom of `poky/build/conf/local.conf`, uncomment one of the `MACHINE` variable assignments ("qemuarm64" or "raspberrypi4-64" depending on whether building for QEMU or Raspberry Pi Model 4b):

```bash
cd poky
source oe-init-build-env
bitbake core-image-spi-tft
```

## Run

Note: base configuration here requires root login on boot, also headless Raspberry Pi 4B boot ouput and login prompt is accessable only through UART GPIO pins. For SD card flash instructions, see: [https://elinux.org/RPi_Easy_SD_Card_Setup](https://elinux.org/RPi_Easy_SD_Card_Setup). 


For QEMU run:

```bash
cd poky
source oe-init-build-env
runqemu nographic
```

