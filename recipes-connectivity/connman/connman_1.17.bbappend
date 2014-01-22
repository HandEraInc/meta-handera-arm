PRINC = "2"

do_install_append() {
	
	# Prevent connman from handling eth0
	sed -i -e 's/eth\[0-9\]/eth\[1-9\]/' ${D}${sysconfdir}/init.d/connman

}
