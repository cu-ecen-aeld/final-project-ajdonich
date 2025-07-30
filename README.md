# Yocto build repo final-project-ajdonich (ECEA 5307)

All code block sequences below assume starting PWD at repo root. For further project details see:
+ Project Wiki: [github.com/cu-ecen-aeld/final-project-ajdonich/wiki](https://github.com/cu-ecen-aeld/final-project-ajdonich/wiki)
+ Project Schedule: [github.com/cu-ecen-aeld/final-project-ajdonich/wiki/Project-Schedule](https://github.com/cu-ecen-aeld/final-project-ajdonich/wiki/Project%E2%80%90Schedule)  
+ Project Board: [github.com/users/ajdonich/projects/SPI-TFT-Display-Driver-Raspberry-Pi](github.com/users/ajdonich/projects/SPI-TFT-Display-Driver-Raspberry-Pi)
+ Project Issues: [github.com/ajdonich/spi-device-driver/issues](https://github.com/ajdonich/spi-device-driver/issues)  
  
## Init

Initialize only needed once after first repo clone. If build host has not been setup:

```bash
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install build-essential chrpath cpio debianutils diffstat file gawk gcc git iputils-ping libacl1 locales python3 python3-git python3-jinja2 python3-pexpect python3-pip python3-subunit socat texinfo unzip wget xz-utils zstd
```

The following will import poky and meta-raspberrypi submodules, initialize the build environment, create build config files from poky templates, and then overwrite them with base versions from this repo's root:

```bash
git submodule update --init --recursive

cd poky
source oe-init-build-env # Creates local.conf and bblayers.conf in build/conf
cp ../../local.conf.base conf/local.conf # Overwrite with base file
cp ../../bblayers.conf.base conf/bblayers.conf # Overwrite with base file
```

## Build

The following will kick off the full Yocto build (multi-hour if this is first build). Note: first go to bottom of `poky/build/conf/local.conf`, uncomment one of the `MACHINE` variable assignments ("qemuarm64" or "raspberrypi4-64" for QEMU or Raspberry Pi Model 4B build respectively):

```bash
cd poky
source oe-init-build-env
bitbake core-image-spi-tft
```

## Run

Note: configuration of `core-image-spi-tft` requires root login on boot, also headless Raspberry Pi 4B boot logs and login prompt are accessable only through UART GPIO pins. For SD card flash instructions, see: [https://elinux.org/RPi_Easy_SD_Card_Setup](https://elinux.org/RPi_Easy_SD_Card_Setup).


For QEMU run:

```bash
cd poky
source oe-init-build-env
runqemu nographic
```



