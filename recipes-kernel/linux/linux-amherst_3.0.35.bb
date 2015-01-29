# Copyright (C) 2013-2014 HandEra, Inc
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

DESCRIPTION = "Linux kernel for HandEra boards"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRCREV = "handera-imx_3.0.35_4.1.0"
SRC_URI = "git://github.com/HandEraInc/handera-linux-imx6.git;branch=handera-imx_3.0.35_4.1.0"
SRC_URI += "file://defconfig"

# Patches need for Yocto and not applied by Freescale when doing 4.1.0 branch
SRC_URI += "file://drm-vivante-Add-00-sufix-in-returned-bus-Id.patch \
            file://epdc-Rename-mxcfb_epdc_kernel.h-to-mxc_epdc.h.patch \
            file://0001-perf-tools-Fix-getrusage-related-build-failure-on-gl.patch \
            file://0002-ARM-7668-1-fix-memset-related-crashes-caused-by-rece.patch \
            file://0003-ARM-7670-1-fix-the-memset-fix.patch \
            file://0004-ENGR00271136-Fix-build-break-when-CONFIG_CLK_DEBUG-i.patch \
            file://0005-ENGR00271359-Add-Multi-touch-support.patch \
            file://0006-Add-support-for-DVI-monitors.patch"

PR = "git${SRCPV}"
PV = "3.0.35"
S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(amherst)"
