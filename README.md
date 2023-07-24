![SeptemTweaks Logo](https://raw.githubusercontent.com/Septem151/SeptemTweaks/master/src/main/resources/assets/septemtweaks/logo.png "SeptemTweaks Logo")

**SeptemTweaks** is a highly opinionated and integrated **Forge** mod for Minecraft version **1.7.10** that will be used in the **SeptemCraft** modpack. This mod introduces linear ore progression consisting of Vanilla, Thermal, and Tinkers ores, as well as restricts the usage of tools to solely Tinker Tools. Additionally, a ton of recipe modifications for Thermal Expansion machinery and Tinkers alloys are included to make processing progression feel meaningful.

Though this mod _is not intended_ to be used outside of the **SeptemCraft** modpack, you may do so if you find these modifications something you might enjoy experiencing. This mod includes integrations/support for:

- [Flint Instead of Wood][flinttools-curse]
- [Clay Bucket][claybucket-curse]
- [BuildCraft][buildcraft-curse]
- [Minefactory Reloaded][mfr-curse]
- [Extra Utilities][extrautils-curse]
- [Applied Energistics 2][ae2-curse]
- [Nether Ores][netherores-curse]
- [Biomes 'O Plenty][bop-curse]
- [Chisel][chisel-curse]
- [Pam's Harvestcraft][harvestcraft-curse]

_NOTE: This mod is in BETA and **does not** have all features implemented_

Ore progression is achieved by modifying the Tinkers Tools' material properties (harvest level) to align with changes to the ores generated by vanilla minecraft and other mods. This means that tools, specifically Pickaxes, outside of Tinkers Construct might not work with this mod and should be considered **incompatible** with mods that add pickaxes.

## Requirements

**SeptemTweaks** is a Forge mod for 1.7.10 that depends on the following mods:

- [Thermal Expansion][te-curse]
- [Tinkers Construct][tcon-curse]

## Features

Features implemented in current release:

- Vanilla tools disabled _(compatibility for non-tinkers pickaxes not added yet)_
  - **Ore progression** drastically changed:
  - _Stones_
  - _Woods_
  - _Coal, Tin, Copper, Aluminum_
  - _Bronze, Iron, Invar, Electrum, Gold, Redstone, Silver, Lead, Lapis_
  - _Steel, Diamonds, Obsidian, Emeralds_
  - _Alumite, Cobalt, Ardite_
  - _Manyullyn_
  - _Platinum, Certus Quartz_
- Thermal Expansion recipes modified to be in-line with ore progression and more resource intensive
- Tinkers Construct alloy changes for Alumite and Signalum
- Vanilla furnace cannot smelt ores

Features in progress for next release:

- Thermal Dynamo recipes modified
- Thermal Energy cell recipes modified
- Thermal Strongbox and Cache blocks removed
- Thermal Machinist's workbench recipe modified, removal of hardened/reinforced/resonant tiers
- Thermal Tesseract recipe modified
- Thermal Satchel recipes modified
- Thermal Augment recipes modified
- Thermal Flux Capacitor recipes modified
- Thermal Armour/Tool recipes removed regardless of CoFH configs
- Tinkers Tool Forge recipes removed except Bronze blocks as the construction base

## Recommendations

- [Flint Instead of Wood][flinttools-curse]
  - _The entire Wood -&gt; Stone progression would be skipped without disabling punching trees. While still possible, it's highly recommended to include this mod_
- [Clay Bucket][claybucket-curse]
  - _Since getting Iron requires a Tinkers Smeltery, you might not be able to fuel the smeltery without a bucket. By all means, if you use another tank/fluid collection mod, use that instead_
- [BuildCraft][buildcraft-curse]
  - _Adjusts various recipes to include some BuildCraft items/blocks_
- [Extra Utilities][extrautils-curse]
  - _Adjusts various recipes to include some ExtraUtilities items/blocks_
- [Minefactory Reloaded][mfr-curse]
  - _Adjusts various recipes to include some MFR items/blocks_

## Screenshots

![SeptemTweaks Ore Progression](https://raw.githubusercontent.com/Septem151/SeptemTweaks/screenshots/ore_tiers.png "Ore Progression")

_Ore Progression shown with the various blocks possible to mine at the given tool material. Blocks on the far-right of a tier indicate the material that's used to mine blocks in the next tier below. For example, Bronze in the stone tier is capable of mining every block in the Bronze tier as well as the tiers before._

![SeptemTweaks Thermal Recipe Modifications](https://raw.githubusercontent.com/Septem151/SeptemTweaks/screenshots/thermal_recipes.png "Thermal Recipe Modifications")

_Various recipes that have been modified by this mod. Some item recipes not shown, for example the addition of gold/silver/electrum wire coils as intermediary crafting materials for thermal coils._

[te-curse]: https://www.curseforge.com/minecraft/mc-mods/thermal-expansion
[tcon-curse]: https://www.curseforge.com/minecraft/mc-mods/tinkers-construct
[flinttools-curse]: https://www.curseforge.com/minecraft/mc-mods/flint-instead-of-wood
[claybucket-curse]: https://www.curseforge.com/minecraft/mc-mods/clay-bucket
[buildcraft-curse]: https://www.curseforge.com/minecraft/mc-mods/buildcraft
[mfr-curse]: https://www.curseforge.com/minecraft/mc-mods/minefactory-reloaded
[extrautils-curse]: https://www.curseforge.com/minecraft/mc-mods/extra-utilities
[ae2-curse]: https://www.curseforge.com/minecraft/mc-mods/applied-energistics-2
[netherores-curse]: https://www.curseforge.com/minecraft/mc-mods/netherores
[bop-curse]: https://www.curseforge.com/minecraft/mc-mods/biomes-o-plenty
[chisel-curse]: https://www.curseforge.com/minecraft/mc-mods/chisel
[harvestcraft-curse]: https://www.curseforge.com/minecraft/mc-mods/pams-harvestcraft
