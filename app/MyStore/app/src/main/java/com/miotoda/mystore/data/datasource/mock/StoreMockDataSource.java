package com.miotoda.mystore.data.datasource.mock;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.miotoda.mystore.data.datasource.StoreDataSource;
import com.miotoda.mystore.data.datasource.dto.StoreResponse;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.inject.Inject;

public class StoreMockDataSource implements StoreDataSource {

    private static final String path = "mocks/data.json";
    private String vish = "{\n" +
            "    \"setores\": [\n" +
            "      {\n" +
            "        \"nome\": \"Alimentos\",\n" +
            "        \"subsetores\": [\n" +
            "          {\n" +
            "            \"nome\": \"Carne\",\n" +
            "            \"marcas\": [\n" +
            "              {\n" +
            "                \"nome\": \"Marca A\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Carne Marca A Estilo 1\",\n" +
            "                    \"SKU\": 1111\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Carne Marca A Estilo 2\",\n" +
            "                    \"SKU\": 1112\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Carne Marca A Estilo 3\",\n" +
            "                    \"SKU\": 1113\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca B\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Carne Marca B Estilo 1\",\n" +
            "                    \"SKU\": 1121\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Carne Marca B Estilo 2\",\n" +
            "                    \"SKU\": 1122\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Carne Marca B Estilo 3\",\n" +
            "                    \"SKU\": 1123\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca C\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Carne Marca C Estilo 1\",\n" +
            "                    \"SKU\": 1131\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Carne Marca C Estilo 2\",\n" +
            "                    \"SKU\": 1132\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Carne Marca C Estilo 3\",\n" +
            "                    \"SKU\": 1133\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"nome\": \"Fruta\",\n" +
            "            \"marcas\": [\n" +
            "              {\n" +
            "                \"nome\": \"Marca A\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Fruta Marca A Estilo 1\",\n" +
            "                    \"SKU\": 1211\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Fruta Marca A Estilo 2\",\n" +
            "                    \"SKU\": 1212\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Fruta Marca A Estilo 3\",\n" +
            "                    \"SKU\": 1213\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca B\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Fruta Marca B Estilo 1\",\n" +
            "                    \"SKU\": 1221\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Fruta Marca B Estilo 2\",\n" +
            "                    \"SKU\": 1222\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Fruta Marca B Estilo 3\",\n" +
            "                    \"SKU\": 1223\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca C\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Fruta Marca C Estilo 1\",\n" +
            "                    \"SKU\": 1231\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Fruta Marca C Estilo 2\",\n" +
            "                    \"SKU\": 1232\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Fruta Marca C Estilo 3\",\n" +
            "                    \"SKU\": 1233\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"nome\": \"Verdura\",\n" +
            "            \"marcas\": [\n" +
            "              {\n" +
            "                \"nome\": \"Marca A\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Verdura Marca A Estilo 1\",\n" +
            "                    \"SKU\": 1311\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Verdura Marca A Estilo 2\",\n" +
            "                    \"SKU\": 1312\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Verdura Marca A Estilo 3\",\n" +
            "                    \"SKU\": 1313\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca B\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Verdura Marca B Estilo 1\",\n" +
            "                    \"SKU\": 1321\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Verdura Marca B Estilo 2\",\n" +
            "                    \"SKU\": 1322\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Verdura Marca B Estilo 3\",\n" +
            "                    \"SKU\": 1323\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca C\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Verdura Marca C Estilo 1\",\n" +
            "                    \"SKU\": 1331\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Verdura Marca C Estilo 2\",\n" +
            "                    \"SKU\": 1332\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Verdura Marca C Estilo 3\",\n" +
            "                    \"SKU\": 1333\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"nome\": \"Roupas\",\n" +
            "        \"subsetores\": [\n" +
            "          {\n" +
            "            \"nome\": \"Camiseta\",\n" +
            "            \"marcas\": [\n" +
            "              {\n" +
            "                \"nome\": \"Marca A\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Camiseta Marca A Estilo 1\",\n" +
            "                    \"SKU\": 2411\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Camiseta Marca A Estilo 2\",\n" +
            "                    \"SKU\": 2412\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Camiseta Marca A Estilo 3\",\n" +
            "                    \"SKU\": 2413\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca B\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Camiseta Marca B Estilo 1\",\n" +
            "                    \"SKU\": 2421\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Camiseta Marca B Estilo 2\",\n" +
            "                    \"SKU\": 2422\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Camiseta Marca B Estilo 3\",\n" +
            "                    \"SKU\": 2423\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca C\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Camiseta Marca C Estilo 1\",\n" +
            "                    \"SKU\": 2431\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Camiseta Marca C Estilo 2\",\n" +
            "                    \"SKU\": 2432\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Camiseta Marca C Estilo 3\",\n" +
            "                    \"SKU\": 2433\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"nome\": \"Pantalon\",\n" +
            "            \"marcas\": [\n" +
            "              {\n" +
            "                \"nome\": \"Marca A\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Pantalon Marca A Estilo 1\",\n" +
            "                    \"SKU\": 2511\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Pantalon Marca A Estilo 2\",\n" +
            "                    \"SKU\": 2512\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Pantalon Marca A Estilo 3\",\n" +
            "                    \"SKU\": 2513\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca B\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Pantalon Marca B Estilo 1\",\n" +
            "                    \"SKU\": 2521\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Pantalon Marca B Estilo 2\",\n" +
            "                    \"SKU\": 2522\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Pantalon Marca B Estilo 3\",\n" +
            "                    \"SKU\": 2523\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca C\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Pantalon Marca C Estilo 1\",\n" +
            "                    \"SKU\": 2531\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Pantalon Marca C Estilo 2\",\n" +
            "                    \"SKU\": 2532\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Pantalon Marca C Estilo 3\",\n" +
            "                    \"SKU\": 2533\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"nome\": \"Moletom\",\n" +
            "            \"marcas\": [\n" +
            "              {\n" +
            "                \"nome\": \"Marca A\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Moletom Marca A Estilo 1\",\n" +
            "                    \"SKU\": 2611\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Moletom Marca A Estilo 2\",\n" +
            "                    \"SKU\": 2612\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Moletom Marca A Estilo 3\",\n" +
            "                    \"SKU\": 2613\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca B\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Moletom Marca B Estilo 1\",\n" +
            "                    \"SKU\": 2621\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Moletom Marca B Estilo 2\",\n" +
            "                    \"SKU\": 2622\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Moletom Marca B Estilo 3\",\n" +
            "                    \"SKU\": 2623\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca C\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Moletom Marca C Estilo 1\",\n" +
            "                    \"SKU\": 2631\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Moletom Marca C Estilo 2\",\n" +
            "                    \"SKU\": 2632\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Moletom Marca C Estilo 3\",\n" +
            "                    \"SKU\": 2633\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"nome\": \"Bebidas\",\n" +
            "        \"subsetores\": [\n" +
            "          {\n" +
            "            \"nome\": \"Sem Alcool\",\n" +
            "            \"marcas\": [\n" +
            "              {\n" +
            "                \"nome\": \"Marca A\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Sem Alcool Marca A Estilo 1\",\n" +
            "                    \"SKU\": 3711\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Sem Alcool Marca A Estilo 2\",\n" +
            "                    \"SKU\": 3712\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Sem Alcool Marca A Estilo 3\",\n" +
            "                    \"SKU\": 3713\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca B\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Sem Alcool Marca B Estilo 1\",\n" +
            "                    \"SKU\": 3721\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Sem Alcool Marca B Estilo 2\",\n" +
            "                    \"SKU\": 3722\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Sem Alcool Marca B Estilo 3\",\n" +
            "                    \"SKU\": 3723\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca C\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Sem Alcool Marca C Estilo 1\",\n" +
            "                    \"SKU\": 3731\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Sem Alcool Marca C Estilo 2\",\n" +
            "                    \"SKU\": 3732\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Sem Alcool Marca C Estilo 3\",\n" +
            "                    \"SKU\": 3733\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"nome\": \"Cerveja\",\n" +
            "            \"marcas\": [\n" +
            "              {\n" +
            "                \"nome\": \"Marca A\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Cerveja Marca A Estilo 1\",\n" +
            "                    \"SKU\": 3811\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Cerveja Marca A Estilo 2\",\n" +
            "                    \"SKU\": 3812\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Cerveja Marca A Estilo 3\",\n" +
            "                    \"SKU\": 3813\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca B\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Cerveja Marca B Estilo 1\",\n" +
            "                    \"SKU\": 3821\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Cerveja Marca B Estilo 2\",\n" +
            "                    \"SKU\": 3822\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Cerveja Marca B Estilo 3\",\n" +
            "                    \"SKU\": 3823\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca C\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Cerveja Marca C Estilo 1\",\n" +
            "                    \"SKU\": 3831\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Cerveja Marca C Estilo 2\",\n" +
            "                    \"SKU\": 3832\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Cerveja Marca C Estilo 3\",\n" +
            "                    \"SKU\": 3833\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"nome\": \"Vinho\",\n" +
            "            \"marcas\": [\n" +
            "              {\n" +
            "                \"nome\": \"Marca A\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Vinho Marca A Estilo 1\",\n" +
            "                    \"SKU\": 3911\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Vinho Marca A Estilo 2\",\n" +
            "                    \"SKU\": 3912\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Vinho Marca A Estilo 3\",\n" +
            "                    \"SKU\": 3913\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca B\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Vinho Marca B Estilo 1\",\n" +
            "                    \"SKU\": 3921\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Vinho Marca B Estilo 2\",\n" +
            "                    \"SKU\": 3922\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Vinho Marca B Estilo 3\",\n" +
            "                    \"SKU\": 3923\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca C\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Vinho Marca C Estilo 1\",\n" +
            "                    \"SKU\": 3931\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Vinho Marca C Estilo 2\",\n" +
            "                    \"SKU\": 3932\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Vinho Marca C Estilo 3\",\n" +
            "                    \"SKU\": 3933\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"nome\": \"Limpeza\",\n" +
            "        \"subsetores\": [\n" +
            "          {\n" +
            "            \"nome\": \"Cozinha\",\n" +
            "            \"marcas\": [\n" +
            "              {\n" +
            "                \"nome\": \"Marca A\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Cozinha Marca A Estilo 1\",\n" +
            "                    \"SKU\": 41011\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Cozinha Marca A Estilo 2\",\n" +
            "                    \"SKU\": 41012\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Cozinha Marca A Estilo 3\",\n" +
            "                    \"SKU\": 41013\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca B\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Cozinha Marca B Estilo 1\",\n" +
            "                    \"SKU\": 41021\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Cozinha Marca B Estilo 2\",\n" +
            "                    \"SKU\": 41022\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Cozinha Marca B Estilo 3\",\n" +
            "                    \"SKU\": 41023\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca C\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Cozinha Marca C Estilo 1\",\n" +
            "                    \"SKU\": 41031\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Cozinha Marca C Estilo 2\",\n" +
            "                    \"SKU\": 41032\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Cozinha Marca C Estilo 3\",\n" +
            "                    \"SKU\": 41033\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"nome\": \"Banho\",\n" +
            "            \"marcas\": [\n" +
            "              {\n" +
            "                \"nome\": \"Marca A\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Banho Marca A Estilo 1\",\n" +
            "                    \"SKU\": 41111\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Banho Marca A Estilo 2\",\n" +
            "                    \"SKU\": 41112\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Banho Marca A Estilo 3\",\n" +
            "                    \"SKU\": 41113\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca B\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Banho Marca B Estilo 1\",\n" +
            "                    \"SKU\": 41121\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Banho Marca B Estilo 2\",\n" +
            "                    \"SKU\": 41122\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Banho Marca B Estilo 3\",\n" +
            "                    \"SKU\": 41123\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca C\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Banho Marca C Estilo 1\",\n" +
            "                    \"SKU\": 41131\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Banho Marca C Estilo 2\",\n" +
            "                    \"SKU\": 41132\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Banho Marca C Estilo 3\",\n" +
            "                    \"SKU\": 41133\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"nome\": \"Pisos\",\n" +
            "            \"marcas\": [\n" +
            "              {\n" +
            "                \"nome\": \"Marca A\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Pisos Marca A Estilo 1\",\n" +
            "                    \"SKU\": 41211\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Pisos Marca A Estilo 2\",\n" +
            "                    \"SKU\": 41212\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Pisos Marca A Estilo 3\",\n" +
            "                    \"SKU\": 41213\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca B\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Pisos Marca B Estilo 1\",\n" +
            "                    \"SKU\": 41221\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Pisos Marca B Estilo 2\",\n" +
            "                    \"SKU\": 41222\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Pisos Marca B Estilo 3\",\n" +
            "                    \"SKU\": 41223\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"nome\": \"Marca C\",\n" +
            "                \"produtos\": [\n" +
            "                  {\n" +
            "                    \"nome\": \"Pisos Marca C Estilo 1\",\n" +
            "                    \"SKU\": 41231\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Pisos Marca C Estilo 2\",\n" +
            "                    \"SKU\": 41232\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"nome\": \"Pisos Marca C Estilo 3\",\n" +
            "                    \"SKU\": 41233\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "\n" +
            "}";

    Gson gson;

    @Inject
    public StoreMockDataSource(Gson gson) {
        this.gson = gson;
    }

    @Override
    public StoreResponse getStore() {

        Gson g = new Gson();
        StoreResponse response = null;
            response = g.fromJson(vish, StoreResponse.class);


        return response;
    }
}
