variable "subscription_id" {
  description = "Your subscription ID."
  type        = string
}

variable "resource_group_name" {
  description = "The name of your resource group."
  type        = string
}

variable "resource_group_location" {
  description = "The location of your resource group."
  type        = string
}

variable "os_type" {
  description = "The type of the OS to be used within the service plan."
  type        = string
}

variable "sku_type" {
  description = "The SKU for the plan."
  type        = string
}

variable "service_plan_name" {
  description = " The name which should be used for this Service Plan."
  type        = string
}

variable "web_app_name" {
  description = "The name which should be used for this Web App."
  type        = string
}

variable "java_version" {
  description = "The Version of Java to use."
  type        = string
}

variable "java_server" {
  description = "The Java server type."
  type        = string
}

variable "java_server_version" {
  description = "The Version of the Java server to use."
  type        = string
}

variable "mysql_server_name" {
  description = "The name which should be used for this MySQL Flexible Server."
  type        = string
}

variable "mysql_firewall_name" {
  description = "The name of the MySQL Firewall Rule."
  type        = string
}

variable "mysql_firewall_start_ip_address" {
  description = "The Start IP Address associated with this Firewall Rule."
  type        = string
}

variable "mysql_firewall_end_ip_address" {
  description = "The End IP Address associated with this Firewall Rule."
  type        = string
}

variable "mysql_admin_login" {
  description = "The Administrator login for the MySQL Flexible Server."
  type        = string
}

variable "mysql_admin_password" {
  description = "The Password associated with the administrator login for the MySQL Flexible Server."
  type        = string
}

variable "mysql_sku_name" {
  description = "The SKU Name for the MySQL Flexible Server."
  type        = string
}

variable "mysql_db_name" {
  description = "The name of the MySQL Database."
  type        = string
}

variable "mysql_db_charset" {
  description = "The charset for the MySQL Database."
  type        = string
}

variable "mysql_db_collation" {
  description = "The Collation for the MySQL Database."
  type        = string
}


variable "source_control_branch" {
  description = "The branch name to use for deployments."
  type        = string
}

variable "source_control_url" {
  description = "The URL for the repository."
  type        = string
}

