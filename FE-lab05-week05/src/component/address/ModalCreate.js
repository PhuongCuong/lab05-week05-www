import { Box, Button, IconButton, Modal, TextField, Typography } from '@mui/material';
import React, { useEffect, useMemo, useState } from 'react';
import CancelIcon from '@mui/icons-material/Cancel';
import SaveIcon from '@mui/icons-material/Save';
import countryList from 'react-select-country-list'
import Select from 'react-select'
import './ModalCreate.scss'

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: "60%",
    bgcolor: 'background.paper',
    pt: 2,
    px: 4,
    pb: 3,
};


const ModalCreate = (props) => {
    const [value, setValue] = useState('')

    const [dataaddress, setdataadress] = useState(
        {
            city: "",
            zipcode: "",
            candidate: null,
            number: "",
            countryCodentry: "",
            street: ""
        }
    )

    const options = useMemo(() => countryList().getData(), [])


    const changeHandler = value => {
        setValue(value)
    }

    const handleOnChange = (event, id) => {
        let copydata = { ...dataaddress }
        copydata[id] = event.target.value;
        setdataadress({ ...copydata })
    }


    useEffect(() => {
        setdataadress({ ...dataaddress, countryCodentry: value.value })
    }, [value])



    return (
        <Modal open={props.opencreate} onClose={() => props.setopencreate(false)}
            aria-labelledby="modal-modal-title"
            aria-describedby="modal-modal-description">
            <Box sx={{ ...style, borderRadius: "5px", outline: "none" }}>
                <Box sx={{ display: "flex", alignItems: "center" }}>
                    <Typography sx={{ fontSize: 18, fontWeight: "550" }}>Thêm Địa Chỉ</Typography>
                    <IconButton sx={{ marginLeft: "auto" }}
                        onClick={() => props.setopencreate(false)}
                    >
                        <CancelIcon />
                    </IconButton>
                </Box>
                <Box component="form" sx={{ display: "flex", flexDirection: "column", justifyContent: "space-around", }} >
                    <TextField sx={{ mt: 2, mr: 3 }}
                        fullWidth
                        size="small"
                        label="Street"
                        variant="outlined"
                        value={dataaddress.street}
                        onChange={(event) => handleOnChange(event, "street")}
                    />
                    <TextField sx={{ mt: 2, mr: 3, mb: 2 }}
                        fullWidth size="small"
                        label="City"
                        variant="outlined"
                        value={dataaddress.city}
                        onChange={(event) => handleOnChange(event, "city")}
                    />
                    <Select className='select-options' options={options} value={value} onChange={changeHandler} />
                    <TextField sx={{ mt: 2, mr: 3 }}
                        fullWidth size="small"
                        label="Number"
                        variant="outlined"
                        value={dataaddress.number}
                        onChange={(event) => handleOnChange(event, "number")}
                    />
                    <TextField sx={{ mt: 2, mr: 3 }}
                        fullWidth size="small"
                        label="Zipcode"
                        variant="outlined"
                        value={dataaddress.zipcode}
                        onChange={(event) => handleOnChange(event, "zipcode")}
                    />
                </Box>
                <Box sx={{ mt: 3, marginLeft: "auto", display: "flex" }}>
                    <Button variant='contained' sx={{ marginLeft: "auto" }}
                        onClick={() => props.createaddress(dataaddress)}
                    >
                        <SaveIcon />
                        <Typography>Save</Typography>
                    </Button>
                </Box>


            </Box>
        </Modal>
    );
};

export default ModalCreate;