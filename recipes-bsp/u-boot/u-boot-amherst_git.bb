# Copyright (C) 2013-2014 HandEra, Inc
# Released under the MIT license (see COPYING.MIT for the terms)
require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4c6cde5df68eff615d36789dc18edd3b"
COMPATIBLE_MACHINE = "(amherst)"

PROVIDES += "u-boot"

DEPENDS_mxs += "elftosb-native"

PV = "v2009.08+git${SRCPV}"

UBOOT_SUFFIX = "bin"
UBOOT_PADDING = "2"

SRCREV = "handera-imx_v2009.08_3.0.35_4.1.0"
SRC_URI = "git://github.com/HandEraInc/handera-uboot-imx6.git;branch=handera-imx_v2009.08_3.0.35_4.1.0"

UBOOT_MAKE_TARGET = "u-boot.bin"

S = "${WORKDIR}/git"
EXTRA_OEMAKE += 'HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_compile_prepend() {
	if [ "${@base_contains('DISTRO_FEATURES', 'ld-is-gold', 'ld-is-gold', '', d)}" = "ld-is-gold" ] ; then
		sed -i 's/$(CROSS_COMPILE)ld/$(CROSS_COMPILE)ld.bfd/g' config.mk
	fi
}

do_compile_append() {
   oe_runmake env
}

do_install_append() {
                install -d ${D}${base_sbindir}
                install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_printenv
                install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_setenv
}

PACKAGES += "${PN}-fw-utils"
FILES_${PN}-fw-utils += "${base_sbindir}/fw_printenv ${base_sbindir}/fw_setenv"


