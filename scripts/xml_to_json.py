import pandas as pd
import numpy as np
import json

setor = []
subsetor = []
marca = []
produto = []


json_ = {
  "data": {
    "setores": [
      {
        "nome": "Alimentos",
        "subsetores": [
          {
            "nome": "Carne",
            "marcas": [
              {
                "nome": "Marca A",
                "produtos": [

                ]
              }
            ]
          }
        ]
      }
    ]
  }
}

# Verify if there is a sector in json_['setores']
def verifySetor(setor):
	for index, i in enumerate(json_['data']['setores']):

		if i['nome'] == setor:
			return index, True

	return False, False

# Verify if there is a sector in json_['setores']
def verifySubSetor(subsetor, i):
	for index, i in enumerate(json_['data']['setores'][i]['subsetores']):

		if i['nome'] == subsetor:
			return index, True
	return False, False

# Verify if there is a sector in json_['setores']
def verifyMarca(marca, i, j):
	for index, i in enumerate(json_['data']['setores'][i]['subsetores'][j]['marcas']):

		if i['nome'] == marca:
			return index, True
	return False, False


#index 0 = setor
#index 1 = subsetor
#index 2 = marca
#index 3 = produto
#index 4 = sku
def doTheThing(data):

	setor = data[0]
	subsetor = data[1]
	marca = data[2]
	produto = data[3]
	sku = data[4]

	i, status = verifySetor(setor)
	
	if not status:

		json_['data']['setores'].append({'nome':setor, 'subsetores': []})


	i, _ = verifySetor(setor)
	j, status = verifySubSetor(subsetor, i)
	if not status:
		json_['data']['setores'][i]['subsetores'].append({'nome':subsetor, 'marcas': []})

	
	i, _ = verifySetor(setor)
	j, _ = verifySubSetor(subsetor, i)	
	k, status = verifyMarca(marca, i, j)
	if not status:
		json_['data']['setores'][i]['subsetores'][j]['marcas'].append({'nome':marca, 'produtos': []})



	i, _ = verifySetor(setor)
	j, _ = verifySubSetor(subsetor, i)	
	k, _ = verifyMarca(marca, i, j)
	json_['data']['setores'][i]['subsetores'][j]['marcas'][k]['produtos'].append({'nome':produto, 'SKU': sku})	

	#print(json_)
	#exit()

	print(json_)

	"""
	return
	if setor not in json_.keys():
		json_[setor] = {}

	if subsetor not in json_[setor].keys():
		json_[setor][subsetor] = {}

	if marca not in json_[setor][subsetor].keys():
		json_[setor][subsetor][marca] = {}

	if produto not in json_[setor][subsetor][marca].keys():
		json_[setor][subsetor][marca][produto] = sku
	"""


def getSingleValues(list):

	list_ = []
	for i in list:
		if i not in list_:
			list_.append(i)

	return list_

df = pd.read_csv('data.csv', sep=',')

for index, row in df.iterrows():
	product = row.tolist()
	doTheThing(product)
	

#print(json.dumps(json_))


with open('data.json', 'w') as f:
	json.dump(json_, f)