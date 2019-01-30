package com.example.demo.view

import de.jensd.fx.glyphs.GlyphsBuilder
import de.jensd.fx.glyphs.GlyphsStack
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconName

class icons{



    var fbicon=GlyphsStack.create().add(GlyphsBuilder.create(FontAwesomeIcon::class.java)
            .icon(FontAwesomeIconName.USER)
            .size("45")

            .build()
    )
    var fb=GlyphsStack.create().add(GlyphsBuilder.create(FontAwesomeIcon::class.java)
            .icon(FontAwesomeIconName.HOME)
            .size("45")

            .build()
    )


    var fb2=GlyphsStack.create().add(GlyphsBuilder.create(FontAwesomeIcon::class.java)
            .icon(FontAwesomeIconName.YOUTUBE)
            .size("45")

            .build()
    )


    var fb3=GlyphsStack.create().add(GlyphsBuilder.create(FontAwesomeIcon::class.java)
            .icon(FontAwesomeIconName.FOLDER)
            .size("45")

            .build()
    )
var googleIcon =GlyphsStack.create().add(GlyphsBuilder.create(FontAwesomeIcon::class.java)
        .icon(FontAwesomeIconName.GOOGLE)
        .size("50")
        .build()
)

}