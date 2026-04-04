terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "=4.67.0"
    }
  }
}

provider "azurerm" {
  features {}
  subscription_id = var.subscription_id
}

resource "azurerm_resource_group" "todoapprg" {
  location = var.resource_group_location
  name     = var.resource_group_name
}

resource "azurerm_service_plan" "service_plan" {
  location            = azurerm_resource_group.todoapprg.location
  name                = var.service_plan_name
  os_type             = var.os_type
  resource_group_name = azurerm_resource_group.todoapprg.name
  sku_name            = var.sku_type
}

resource "azurerm_linux_web_app" "todoapp-web-app" {
  location            = azurerm_resource_group.todoapprg.location
  name                = var.web_app_name
  resource_group_name = azurerm_resource_group.todoapprg.name
  service_plan_id     = azurerm_service_plan.service_plan.id

  site_config {
    always_on = false

    application_stack {
      java_version        = var.java_version
      java_server         = var.java_server
      java_server_version = var.java_server_version
    }
  }

  connection_string {
    name  = "MYSQL_CONNECTION"
    type  = "MySql"
    value = "Server=${azurerm_mysql_flexible_server.mysql_server.fqdn};Database=${azurerm_mysql_flexible_database.mysql_database.name};User Id=${var.mysql_admin_login};Password=${var.mysql_admin_password};"
  }
}

resource "azurerm_mysql_flexible_server" "mysql_server" {
  location               = azurerm_resource_group.todoapprg.location
  name                   = var.mysql_server_name
  resource_group_name    = azurerm_resource_group.todoapprg.name
  administrator_login    = var.mysql_admin_login
  administrator_password = var.mysql_admin_password
  sku_name               = var.mysql_sku_name
}

resource "azurerm_mysql_flexible_server_firewall_rule" "firewall-rule" {
  end_ip_address      = var.mysql_firewall_end_ip_address
  name                = var.mysql_firewall_name
  resource_group_name = azurerm_resource_group.todoapprg.name
  server_name         = azurerm_mysql_flexible_server.mysql_server.name
  start_ip_address    = var.mysql_firewall_start_ip_address
}

resource "azurerm_mysql_flexible_database" "mysql_database" {
  charset             = var.mysql_db_charset
  collation           = var.mysql_db_collation
  name                = var.mysql_db_name
  resource_group_name = azurerm_resource_group.todoapprg.name
  server_name         = azurerm_mysql_flexible_server.mysql_server.name
}

resource "azurerm_app_service_source_control" "source_control" {
  app_id   = azurerm_linux_web_app.todoapp-web-app.id
  branch   = var.source_control_branch
  repo_url = var.source_control_url

  use_manual_integration = true
}







