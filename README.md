# MultiChat
MultiChat plugin for Nukkit.

This plugin is change chat format according to player's group. 
MultiChat created as companion for permissions plugin Multipass and 
will not support any other permissions plugin.

##Commands
###Show help
> \/chat help

Show help for plugin MultiChat

###Configure chat format
> \/chat set chat \<group\> \<chat format\>

Configure default chat format

Example:

``/chat set chat vip &6[VIP]%player%: &a%message%``

###Configure name tag
> \/chat set name \<group\> \<name tag format\>
> \/chat set tag \<group\> \<name tag format\>
> \/chat set nametag \<group\> \<name tag format\>


Configure default name tag format

``/chat set tag vip &6[VIP]%player%``

###Configure group chat format
> \/chat group chat \<group\> \<chat format\>

Configure chat format for players of defined group

Example:

``/chat group chat vip &6[VIP]%player%: &a%message%``

###Configure group name tag
> \/chat group name \<group\> \<name tag format\>
> \/chat group tag \<group\> \<name tag format\>
> \/chat group nametag \<group\> \<name tag format\>


Configure name tag for players of defined group

``/chat group tag vip &6[VIP]%player%``

###Reload
> \/chat reload

Reload plugin configuration

##Configuration 
```
general:
  language: default
  language-save: false
  debug: false
chat:
  format: '&2%prefix%a2%player%&e: %message%'
name-tag:
  enable: true
  format: '&a%prefix%&6%player%'
display-name:
  enable: true
  strip-colors: false
group:
  scan-subgroups: true
  format:
    default:
      chat: '&5[GUEST]&3%player%&a: 6%message%'
    vip:
      chat: '&6[VIP]&4%player%&a: %message%'
      name-tag: '&6[VIP] &4%player%'
```
