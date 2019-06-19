# Hardcore-Temp-Ban-Spigot
A plugin created for Spigot. Every time a player dies they will lose 2.5 hearts off their max health. When reaching zero they will be banned for 4 hours.

## Commands
Commands | Permission Node | Description
------------ | ------------- | -------------
/restore \[<player>\] | hcb.command.restore | Restores 5(2.5 hearts) max-health and gives the player regeneration 1
/fullrestore \[<player>\] | hcb.command.fullrestore | Restores Player's max health and current health to 20(10 hearts)
/removeban <player> | hcb.command.removeban | Removes temporary ban from player
/removehealth \[<player>\] | hcb.command.removehealth | Removes 5(2.5 hearts) max-health
/givecoupon \[<amount>\] [<player>] | hcb.command.givecoupon | Gives Players an amount of life coupons
