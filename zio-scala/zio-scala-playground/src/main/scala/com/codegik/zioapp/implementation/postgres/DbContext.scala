package com.codegik.zioapp
package implementation
package postgres

import com.codegik.quill.CustomQuillNamingStrategy
import io.getquill.PostgresZioJdbcContext

lazy val DbContext = new PostgresZioJdbcContext(CustomQuillNamingStrategy)
