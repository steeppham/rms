<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:x="http://www.w3.org/1999/xhtml" version="1.1"
	exclude-result-prefixes="x">
	<xsl:output method="xml" indent="yes" />

	<xsl:template match="x:html">
		<registrations>
			<xsl:apply-templates select="x:body/x:div/x:div/x:div/x:table" />
		</registrations>
	</xsl:template>

	<xsl:template match="x:table">
		<xsl:for-each select="x:tbody/x:tr">
			<xsl:choose>
				<xsl:when test="position() != last()">
					<xsl:apply-templates select="." />
				</xsl:when>
			</xsl:choose>
		</xsl:for-each>
	</xsl:template>

	<xsl:template match="x:tr">
		<postcode>
			<code>
				<xsl:value-of select="x:th" />
			</code>
			<total>
				<xsl:value-of select="x:td[1]" />
			</total>
			<vehicles>
				<xsl:for-each select="x:td[position() != 1]">
					<xsl:variable name="i" select="position()" />
					<vehicle>
						<name>
							<xsl:value-of
								select="/x:html/x:body/x:div/x:div/x:div/x:table/x:thead/x:tr[2]/x:th[$i]" />
						</name>
						<total>
							<xsl:value-of select="." />
						</total>
					</vehicle>
				</xsl:for-each>
			</vehicles>
		</postcode>
	</xsl:template>

</xsl:stylesheet>
