<?xml version="1.0" encoding="utf-8"?>
<!-- https://www.jenitennison.com/xslt/grouping/muenchian.html -->
<!-- https://stackoverflow.com/questions/35297513/xslt-and-muenchian-grouping-multiple-level-sample -->
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:key name="rows-by-region" match="ROW"
		use="COLUMN[@NAME='REGION_ID']" />
	<xsl:key name="rows-by-region-and-country" match="ROW"
		use="concat(COLUMN[@NAME='REGION_ID'],'|',COLUMN[@NAME='COUNTRY_ID'])" />

	<xsl:template match="RESULTS">
		<xsl:for-each
			select="ROW[generate-id(.)=generate-id(key('rows-by-region',COLUMN[@NAME='REGION_ID']))]">
			<xsl:variable name="region-id" select="COLUMN[@NAME='REGION_ID']" />
			<xsl:text>&#10;</xsl:text>
			<xsl:element name="REGION">
				<xsl:attribute name="id">
                <xsl:value-of select="$region-id" />
              </xsl:attribute>
				<xsl:attribute name="name">
                <xsl:value-of select="COLUMN[@NAME='REGION_NAME']" />
              </xsl:attribute>
				<xsl:for-each
					select="key('rows-by-region',$region-id)[generate-id(.)=generate-id(key('rows-by-region-and-country',concat($region-id,'|',COLUMN[@NAME='COUNTRY_ID'])))]">
					<xsl:variable name="country-id" select="COLUMN[@NAME='COUNTRY_ID']" />
					<xsl:text>&#10;</xsl:text>
					<xsl:element name="COUNTRY">
						<xsl:attribute name="id">
                          <xsl:value-of select="$country-id" />
                        </xsl:attribute>
						<xsl:attribute name="name">
                          <xsl:value-of select="COLUMN[@NAME='COUNTRY_NAME']" />
                        </xsl:attribute>
						<xsl:for-each
							select="key('rows-by-region-and-country',concat($region-id,'|',$country-id))">
							<xsl:text>&#10;</xsl:text>
							<xsl:element name="LOCATION">
								<xsl:attribute name="id">
                                  <xsl:value-of
									select="COLUMN[@NAME='LOCATION_ID']" />
                                </xsl:attribute>
								<xsl:attribute name="state_province">
                                  <xsl:value-of
									select="COLUMN[@NAME='STATE_PROVINCE']" />
                                </xsl:attribute>
								<xsl:attribute name="state_province">
                                  <xsl:value-of
									select="COLUMN[@NAME='STATE_PROVINCE']" />
                                </xsl:attribute>
								<xsl:attribute name="POSTAL_CODE">
                                  <xsl:value-of
									select="COLUMN[@NAME='POSTAL_CODE']" />
                                </xsl:attribute>
								<xsl:attribute name="CITY">
                                  <xsl:value-of select="COLUMN[@NAME='CITY']" />
                                </xsl:attribute>
								<xsl:attribute name="STREET_ADDRESS">
                                  <xsl:value-of
									select="COLUMN[@NAME='STREET_ADDRESS']" />
                                </xsl:attribute>
							</xsl:element>
						</xsl:for-each>
						<xsl:text>&#10;</xsl:text>
					</xsl:element>
				</xsl:for-each>
				<xsl:text>&#10;</xsl:text>
			</xsl:element>
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>