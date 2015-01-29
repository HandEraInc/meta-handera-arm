FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

#PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://00001-change-default_frame-pluse_to-1.patch"

