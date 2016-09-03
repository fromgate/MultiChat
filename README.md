# MultiChat
MultiChat plugin for Nukkit.

This plugin is change chat format according to player's group. 
MultiChat created as companion for permissions plugin Multipass and 
will not support any other permissions plugin.

##Permissions
> multichat.config

Allows to use MultiChat's commands

##Commands
###Show help
> /chat help

Show help for plugin MultiChat

###Configure chat format
> /chat set chat \<group\> \<chat format\>

Configure default chat format

Example:

``/chat set chat vip &6[VIP]%player%: &a%message%``

###Configure name tag
> /chat set name \<group\> \<name tag format\>

> /chat set tag \<group\> \<name tag format\>

> /chat set nametag \<group\> \<name tag format\>


Configure default name tag format

``/chat set tag vip &6[VIP]%player%``

###Configure group chat format
> /chat group chat \<group\> \<chat format\>

Configure chat format for players of defined group

Example:

``/chat group chat vip &6[VIP]%player%: &a%message%``

###Configure group name tag
> /chat group name \<group\> \<name tag format\>

> /chat group tag \<group\> \<name tag format\>

> /chat group nametag \<group\> \<name tag format\>


Configure name tag for players of defined group

``/chat group tag vip &6[VIP]%player%``

###Reload
> /chat reload

Reload plugin configuration

##Configuration 
```
# MultiChat, chat format plugin for Multipass
#
general:
# Messages language. Supported languages:
# eng - English
  language: default
# Save translation file
  language-save: false
# Debug mode. Usually you don't need to turn it on
  debug: false
chat:
# Default chat format
  format: '&2%prefix%a2%player%&e: %message%'
name-tag:
# Default name-tag format
  enable: true
  format: '&a%prefix%&6%player%'
display-name:
# Enable display name (shown by TAB-key)
  enable: true
# Remove color codes from display name
  strip-colors: false

# Per-group formats configuration
group:
# Scan sub-groups (group in groups)
  scan-subgroups: true
# Chat format 
  format:
# List of groups
# First - lower prity,  last - higher
# For example, if player are member of three groups: default, vip and admin
# Will used format describe in last group in list - admin 
    default: # Group name
      chat: '&5[GUEST]&3%player%&a: 6%message%' # Chat format
    vip: # Group name
      chat: '&6[VIP]&e%player%&a: %message%' # Chat format
      name-tag: '&6[VIP] &4%player%' # Name tag format
    admin: 
      '&4[ADM]&c%player%e:&a %message'
      name-tag: '&4[admin] &4%player%' # Name tag format
```
