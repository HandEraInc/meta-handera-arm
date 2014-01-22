PRINC = "2"

do_install_append() {
	
	# Prevent connman from handling eth0
	sed -i -e 's/EXTRA_PARAM=\"\"/EXTRA_PARAM=\"-I eth0\"/' ${D}${sysconfdir}/init.d/connman

}
