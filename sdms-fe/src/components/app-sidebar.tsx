import { Home, Settings2, Shield, Users } from "lucide-react";
import * as React from "react";
import { useTranslation } from "react-i18next";
import { useLocation } from "react-router-dom";

import LanguageSwitcher from "@/components/language-switcher";
import { LogoHeader } from "@/components/logo-header";
import { NavUser } from "@/components/nav-user";
import {
  Sidebar,
  SidebarContent,
  SidebarFooter,
  SidebarGroup,
  SidebarGroupLabel,
  SidebarHeader,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
  SidebarRail,
  useSidebar,
} from "@/components/ui/sidebar";
import { useAuth } from "@/context/auth-context";
import { ThemeToggle } from "@/components/theme-toggle";

export function AppSidebar({ ...props }: React.ComponentProps<typeof Sidebar>) {
  const { isAdmin } = useAuth();
  const location = useLocation();
  const { t } = useTranslation();
  const { state } = useSidebar();
  const isCollapsed = state === "collapsed";

  const mainNavItems = [
    {
      title: t("navigation.main.home"),
      icon: Home,
      href: "/home",
      isActive: location.pathname === "/home",
    },
  ];

  const adminNavItems = [
    {
      title: t("navigation.admin.userManagement"),
      icon: Users,
      href: "/admin/users",
      isActive: location.pathname.startsWith("/admin/users"),
    },
    {
      title: t("navigation.admin.roles"),
      icon: Shield,
      href: "/admin/roles",
      isActive: location.pathname.startsWith("/admin/roles"),
    },
  ];

  return (
    <Sidebar collapsible="icon" {...props}>
      <SidebarHeader>
        <div className="flex items-center justify-between px-2 h-[52px]">
          {/* Show only logo when collapsed */}
          <div className={`${isCollapsed ? "w-full flex justify-center" : ""}`}>
            <LogoHeader />
          </div>
          {/* Hide language switcher and theme toggle when collapsed */}
          {!isCollapsed && (
            <div className="flex items-center gap-2">
              <LanguageSwitcher />
              <ThemeToggle />
            </div>
          )}
        </div>
      </SidebarHeader>
      <SidebarContent>
        {/* Main Navigation */}
        <SidebarGroup>
          <SidebarGroupLabel>{t("navigation.main.title")}</SidebarGroupLabel>
          <SidebarMenu>
            {mainNavItems.map((item) => (
              <SidebarMenuItem key={item.href}>
                <SidebarMenuButton asChild tooltip={item.title} isActive={item.isActive}>
                  <a href={item.href}>
                    <item.icon />
                    <span>{item.title}</span>
                  </a>
                </SidebarMenuButton>
              </SidebarMenuItem>
            ))}
          </SidebarMenu>
        </SidebarGroup>

        {/* Admin Navigation */}
        {isAdmin && (
          <SidebarGroup>
            <SidebarGroupLabel>{t("navigation.admin.title")}</SidebarGroupLabel>
            <SidebarMenu>
              {adminNavItems.map((item) => (
                <SidebarMenuItem key={item.href}>
                  <SidebarMenuButton asChild tooltip={item.title} isActive={item.isActive}>
                    <a href={item.href}>
                      <item.icon />
                      <span>{item.title}</span>
                    </a>
                  </SidebarMenuButton>
                </SidebarMenuItem>
              ))}
            </SidebarMenu>
          </SidebarGroup>
        )}
      </SidebarContent>
      <SidebarFooter>
        <div className={`flex items-center ${isCollapsed ? "justify-center" : "justify-between"} px-2`}>
          <NavUser />
        </div>
      </SidebarFooter>
      <SidebarRail />
    </Sidebar>
  );
}