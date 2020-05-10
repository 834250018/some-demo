把json还原成数组
List<?> list = JSON.parseObject(jsonStr, new TypeReference<List<?>>() {}); 