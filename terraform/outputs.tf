output "webapp_url" {
  value = azurerm_linux_web_app.todoapp-web-app.default_hostname
}

output "mysql_server_id" {
  value = azurerm_mysql_flexible_server.mysql_server.id
}

output "mysql_db_id" {
  value = azurerm_mysql_flexible_database.mysql_database.id
}

output "service_plan_id" {
  value = azurerm_service_plan.service_plan.id
}