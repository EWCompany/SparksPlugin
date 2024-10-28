package org.example.gtrg.sparksplugin;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.gtrg.sparksplugin.utilites.translator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SparksPlugin extends JavaPlugin {
    public static File config;
    public static File lang;
    public static File Data;
    public static YamlConfiguration Yamllang;
    public static YamlConfiguration YamlConfig;
    public static YamlConfiguration YamlData;

    @Override
    public void onEnable() {
            if (!getDataFolder().exists()) {
                getLogger().info(translator.translate("&a[Mark] Hello! I am a smart assistant built into the plugin."));
                getLogger().info(translator.translate("&a[Mark] My name is Mark, I was developed by Glove Studios."));
                getLogger().info(translator.translate("&a[Mark] And I see that you installed our plugin for the first time and now I will help you start using it."));
                getLogger().info(translator.translate("&a[Mark] So let's start with one question! What language will be more convenient for you to use to work with this plugin?"));
                getLogger().info(translator.translate("&a[Mark] To answer this question, indicate the first two letters of the language in which you will be more comfortable working with this plugin in the file current_language.yml"));
                getLogger().info(translator.translate("&a[Mark] This file can be found in the SparksPlugin directory, which is located in the plugins directory, this directory is in the root directory of your minecraft server."));
                getLogger().info(translator.translate("&a[Mark] Here is a list of supported languages for this version of the plugin: English - EN, Russian - RU, Belarusian - BY, Ukrainian - UA, Kazakhstani - KZ languages."));
                getLogger().info(translator.translate("&a[Mark] And next to each language in this list there are letters that must be inserted into the file to activate the language you selected."));
                getDataFolder().mkdirs();
            }
            Data = new File(getDataFolder(), "data.yml");
            lang = new File(getDataFolder(), "current_language.yml");
            config = new File(getDataFolder(), "options.yml");

          if (!lang.exists()) {
            try {
                lang.createNewFile();
                try (BufferedWriter langwriter = new BufferedWriter(new FileWriter(lang))) {
                    langwriter.write("# This parameter controls the current plugin language of the value. Can be changed to EN, RU, BY, UA, KZ.\n");
                    langwriter.write("language: 'EN'\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
          }
        Yamllang = YamlConfiguration.loadConfiguration(lang);
            if (!config.exists()) {
                try {
                    config.createNewFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(config))) {
                        if (Yamllang.getString("language").equals("EN")) {
                            writer.write("# This message will be sent to the console and to the sender of this command when the reload is successful\n");
                            writer.write("successful_reload: '&aSuccessful reload!'\n");
                            writer.write("# This message will be sent when the command sender is not a player\n");
                            writer.write("only_player_run_command: '&cOnly players can send such a command!'\n");
                            writer.write("# This message will be sent to the player when he buys additional hearts for sparks\n");
                            writer.write("successful_purchase: '&aYou have successfully acquired 2 Health!'\n");
                            writer.write("# This message will be received by the player every time he tries to buy additional hearts with sparks but does not have enough sparks\n");
                            writer.write("not_enough_sparks: '&cYou don`t have enough sparks!'\n");
                            writer.write("# This message will be sent to the player if he enters a command that is missing one or more arguments\n");
                            writer.write("not_complete_set_of_arguments: '&cYou entered an incomplete command!'\n");
                            writer.write("# This value determines the number of sparks that the player needs to successfully purchase hearts\n");
                            writer.write("number_of_sparks_to_buy_hearts: '200'\n");
                            writer.write("# This list will contain those blocks on which the plugin will be triggered when they are broken. \n");
                        } else if (Yamllang.getString("language").equals("RU")) {
                            writer.write("# Это сообщение будет отправлено в консоль и отправителю этой команды при успешной перезагрузке.\n");
                            writer.write("successful_reload: '&aУспешная перезагрузка!'\n");
                            writer.write("# Это сообщение будет отправлено, если отправитель команды не является игроком.\n");
                            writer.write("only_player_run_command: '&cТолько игроки могут использовать эту комманду!'\n");
                            writer.write("# Это сообщение будет отправлено игроку, когда он купит дополнительные сердца за спарки.\n");
                            writer.write("successful_purchase: '&aВы успешно купили 2 сердца!'\n");
                            writer.write("# Это сообщение будет получать игрок каждый раз, когда он попытается купить дополнительные сердца за спарки, но у него недостаточно спарков.\n");
                            writer.write("not_enough_sparks: '&cУ вас недостаточно спарков!'\n");
                            writer.write("# Это сообщение будет отправлено игроку, если он введет команду, в которой отсутствует один или несколько аргументов.\n");
                            writer.write("not_complete_set_of_arguments: '&cВы ввели неполную команду!'\n");
                            writer.write("# Это значение определяет количество спарков, необходимое игроку для успешной покупки сердец.\n");
                            writer.write("number_of_sparks_to_buy_hearts: '200'\n");
                            writer.write("# В этом списке будут те блоки, на которых плагин будет срабатывать при их поломке.\n");
                    } else if (Yamllang.getString("language").equals("UA")) {
                            writer.write("# Це повідомлення буде надіслано на консоль і відправнику цієї команди після успішного перезавантаження\n");
                            writer.write("successful_reload: '&aУспішне перезавантаження!'\n");
                            writer.write("# Це повідомлення буде надіслано, якщо відправник команди не є гравцем\n");
                            writer.write("only_player_run_command: '&cЛише гравці можуть надсилати таку команду!'\n");
                            writer.write("# Це повідомлення буде надіслано гравцеві, коли він придбає додаткові серця за іскри\n");
                            writer.write("successful_purchase: '&aВи успішно отримали 2 здоров'я!'\n");
                            writer.write("# Це повідомлення отримуватиме гравець кожного разу, коли він намагатиметься купити додаткові серця з іскрами, але не матиме достатньо іскор\n");
                            writer.write("not_enough_sparks: '&cУ вас недостатньо іскор!'\n");
                            writer.write("# Це повідомлення буде надіслано гравцеві, якщо він введе команду, у якій відсутні один або більше аргументів\n");
                            writer.write("not_complete_set_of_arguments: '&cВи ввели неповну команду!'\n");
                            writer.write("# Це значення визначає кількість іскор, які необхідні гравцеві, щоб успішно придбати серця\n");
                            writer.write("number_of_sparks_to_buy_hearts: '200'\n");
                            writer.write("# Цей список міститиме ті блоки, на яких плагін буде запускатися, коли вони зламані.");
                        } else if (Yamllang.getString("language").equals("KZ")) {
                            writer.write("# Бұл хабарлама сәтті қайта жүктелгеннен кейін консольге және осы пәрменді жіберушіге жіберіледі.\n");
                            writer.write("successful_reload: '&aСәтті қайта жүктеу!'\n");
                            writer.write("# Бұл хабар пәрменді жіберуші ойыншы болмаса жіберіледі.\n");
                            writer.write("only_player_run_command: '&cБұл пәрменді тек ойыншылар пайдалана алады!'\n");
                            writer.write("# Бұл хабар ойыншы ұшқындары бар қосымша жүрекшелерді сатып алғанда оған жіберіледі.\n");
                            writer.write("successful_purchase: '&aСіз 2 жүректі сәтті сатып алдыңыз!'\n");
                            writer.write("# Ойыншы ұшқындары бар қосымша жүрекшелерді сатып алуға тырысқан сайын, бірақ ұшқындары жеткіліксіз болған сайын осы хабарды алады.\n");
                            writer.write("not_enoughsparks: '&cСізде ұшқындар жеткіліксіз!'\n");
                            writer.write("# Ойыншы бір немесе бірнеше аргументі жоқ пәрменді енгізсе, бұл хабарлама оған жіберіледі.\n");
                            writer.write("аргументтердің_толтырылмауы: '&cСіз толық емес пәрмен енгіздіңіз!'\n");
                            writer.write("# Бұл мән ойыншының жүректерді сәтті сатып алуы үшін қажет ұшқындардың санын анықтайды.\n");
                            writer.write("жүректерді_сатып алу_үшін_ұшқындар_саны: '200'\n");
                            writer.write("# Бұл тізімде плагин бұзылған кезде іске қосылатын блоктар болады.");
                        } else if (Yamllang.getString("language").equals("BY")) {
                            writer.write("# Гэта паведамленне будзе адпраўлена ў кансоль і адпраўніку гэтай каманды пры паспяховай перазагрузцы.\n");
                            writer.write("successful_reload: '&aПаспяховая перазагрузка!'\n");
                            writer.write("# Гэта паведамленне будзе адпраўлена, калі адпраўнік каманды не з'яўляецца гульцом.\n");
                            writer.write("only_player_run_command: '&cТолькі гульцы могуць выкарыстоўваць гэтую каманду!'\n");
                            writer.write("# Гэта паведамленне будзе адпраўлена гульцу, калі ён купіць дадатковыя сэрцы за спаркі.\n");
                            writer.write("successful_purchase: '&aВы паспяхова купілі 2 сэрцы!'\n");
                            writer.write("# Гэта паведамленне будзе атрымліваць гулец кожны раз, калі ён паспрабуе купіць дадатковыя сэрцы за спаркі, але ў яго недастаткова спарков.\n");
                            writer.write("not_enough_sparks: '&cУ вас недастаткова спаркаў!'\n");
                            writer.write("# Гэта паведамленне будзе адпраўлена гульцу, калі ён увядзе каманду, у якой адсутнічае адзін або некалькі аргументаў.\n");
                            writer.write("not_complete_set_of_arguments: '&cВы ўвялі няпоўную каманду!'\n");
                            writer.write("# Гэта значэнне вызначае колькасць спаркаў, неабходнае гульцу для паспяховай пакупкі сэрцаў.\n");
                            writer.write("number_of_sparks_to_buy_hearts: '200'\n");
                            writer.write("# Гэты спіс будзе ўтрымліваць тыя блокі, на якіх убудова будзе запускацца пры іх узломе.\n");
                        } else {
                            getLogger().warning(translator.translate("&cLanguage error. Please check your language settings in the current_language.yml file"));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    if (Yamllang.getString("language").equals("EN")) {
                        throw new RuntimeException("Error!Could not create config file.Disabling!", e);
                    } else if (Yamllang.getString("language").equals("RU")) {
                        throw new RuntimeException("Ошибка!Не удалось создать файл конфигурации.Выключение!");
                    } else if (Yamllang.getString("language").equals("UA")) {
                        throw new RuntimeException("Помилка! Не вдалося створити конфігураційний файл! Вимкнення!");
                    } else if (Yamllang.getString("language").equals("KZ")) {
                        throw new RuntimeException("Қате! Конфигурация файлын жасау сәтсіз аяқталды! Өшіру!");
                    } else if (Yamllang.getString("language").equals("BY")) {
                        throw new RuntimeException("Памылка! Не ўдалося стварыць файл канфігурацыі! Выключэнне!");
                    }
                }
            }
        if (!Data.exists()) {
            try {
                config.createNewFile();
                try (BufferedWriter datawriter = new BufferedWriter(new FileWriter(Data))) {
                    if (Yamllang.getString("language").equals("EN")) {
                        datawriter.write("# This file contains player data that relates to this plugin. Therefore, I do not recommend changing anything here.\n");
                    } else if (Yamllang.getString("language").equals("RU")) {
                        datawriter.write("# В этом файле находятся данные игроков которые касаются этого плагина.По этому не советую что-либо здесь менять.");
                    } else if (Yamllang.getString("language").equals("UA")) {
                        datawriter.write("# У цьому файлі знаходяться дані гравців які стосуються цього плагіна. Тому не раджу щось тут міняти.");
                    } else if (Yamllang.getString("language").equals("KZ")) {
                        datawriter.write("# Бұл файлда осы плагинге қатысты ойнатқыш деректері бар, сондықтан мен мұнда ештеңені өзгертуді ұсынбаймын.");
                    } else if (Yamllang.getString("language").equals("BY")) {
                        datawriter.write("# У гэтым файле знаходзяцца дадзеныя гульцоў якія датычацца гэтага плагіна. Таму не раю штосьці тут мяняць.");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

            YamlData = YamlConfiguration.loadConfiguration(Data);
            YamlConfig = YamlConfiguration.loadConfiguration(config);
            getServer().getPluginManager().registerEvents(new Events(this), this);
             if (Yamllang.getString("language").equals("EN")) {
                 getLogger().info(translator.translate("&a###########################################"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a#          SparkPlugin V1-Beta            #"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a#               Enabling                  #"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a###########################################"));
             } else if (Yamllang.getString("language").equals("RU")) {
                 getLogger().info(translator.translate("&a###########################################"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a#          SparkPlugin V1-Beta            #"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a#               Включение                 #"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a###########################################"));
             } else if (Yamllang.getString("language").equals("UA")) {
                 getLogger().info(translator.translate("&a###########################################"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a#          SparkPlugin V1-Beta            #"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a#               Увімкнення                #"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a###########################################"));
             } else if (Yamllang.getString("language").equals("KZ")) {
                 getLogger().info(translator.translate("&a###########################################"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a#          SparkPlugin V1-Beta            #"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a#                  Қосу                   #"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a###########################################"));
             } else if (Yamllang.getString("language").equals("BY")) {
                 getLogger().info(translator.translate("&a###########################################"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a#          SparkPlugin V1-Beta            #"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a#               Уключэнне                 #"));
                 getLogger().info(translator.translate("&a#                                         #"));
                 getLogger().info(translator.translate("&a###########################################"));
                     } else {
                         getLogger().warning("Спроба праверыць ключ на ліцэнзійнасць не ўдалася ці вынік праверкі быў адмоўны! Выключэнне!");
                         getPluginLoader().disablePlugin(this);
                     }
                 }




    public void onDisable() {
        if (Yamllang.getString("language").equals("EN")) {
            getLogger().info(translator.translate("&a###########################################"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a#          SparkPlugin V1-Beta            #"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a#               Disabling                 #"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a###########################################"));
        } else if (Yamllang.getString("language").equals("RU")) {
            getLogger().info(translator.translate("&a###########################################"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a#          SparkPlugin V1-Beta            #"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a#               Включение                 #"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a###########################################"));
        } else if (Yamllang.getString("language").equals("UA")) {
            getLogger().info(translator.translate("&a###########################################"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a#          SparkPlugin V1-Beta            #"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a#               Вимкнення                 #"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a###########################################"));
        } else if (Yamllang.getString("language").equals("KZ")) {
            getLogger().info(translator.translate("&a###########################################"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a#          SparkPlugin V1-Beta            #"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a#                 Өшіру                   #"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a###########################################"));
        } else if (Yamllang.getString("language").equals("BY")) {
            getLogger().info(translator.translate("&a###########################################"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a#          SparkPlugin V1-Beta            #"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a#               Выключэнне                #"));
            getLogger().info(translator.translate("&a#                                         #"));
            getLogger().info(translator.translate("&a###########################################"));
        }
    }
}