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


const ModalUpdate = (props) => {


    const [value, setValue] = useState('')
    const [dataupdate, setdataupdate] = useState({});
    const options = useMemo(() => countryList().getData(), [])

    const countrycode = options.find(item => item.value === dataupdate.countryCodentry);

    const changeHandler = value => {
        setValue(value)
    }

    const handleOnChange = (event, id) => {
        let copydata = { ...dataupdate }
        copydata[id] = event.target.value;
        setdataupdate({ ...copydata })
    }

    useEffect(() => {
        if (value && value.value)
            setdataupdate({ ...dataupdate, countryCodentry: value.value })
    }, [value])

    useEffect(() => {
        setdataupdate(props.dataupdate)
    }, [props.dataupdate])

    useEffect(() => {
        setValue(countrycode)
    }, [countrycode])



    return (
        <Modal open={props.openupdate} onClose={() => props.setopenupdate(false)}
            aria-labelledby="modal-modal-title"
            aria-describedby="modal-modal-description">
            <Box sx={{ ...style, borderRadius: "5px", outline: "none" }}>
                <Box sx={{ display: "flex", alignItems: "center" }}>
                    <Typography sx={{ fontSize: 18, fontWeight: "550" }}>Update Địa Chỉ</Typography>
                    <IconButton sx={{ marginLeft: "auto" }}
                        onClick={() => props.setopenupdate(false)}
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
                        defaultValue={dataupdate.street}
                        onChange={(event) => handleOnChange(event, "street")}
                    />
                    <TextField sx={{ mt: 2, mr: 3, mb: 2 }}
                        fullWidth
                        size="small"
                        label="City"
                        variant="outlined"
                        defaultValue={dataupdate.city}
                        onChange={(event) => handleOnChange(event, "city")}


                    />
                    <Select className='select-options'
                        options={options}
                        value={value}
                        onChange={changeHandler}

                    />
                    <TextField sx={{ mt: 2, mr: 3 }}
                        fullWidth
                        size="small"
                        label="Number"
                        variant="outlined"
                        defaultValue={dataupdate.number}
                        onChange={(event) => handleOnChange(event, "number")}

                    />
                    <TextField sx={{ mt: 2, mr: 3 }}
                        fullWidth
                        size="small"
                        label="Zipcode"
                        variant="outlined"
                        defaultValue={dataupdate.zipcode}
                        onChange={(event) => handleOnChange(event, "zipcode")}

                    />
                </Box>
                <Box sx={{ mt: 3, marginLeft: "auto", display: "flex" }}>
                    <Button variant='contained' sx={{ marginLeft: "auto" }}
                        onClick={() => props.handleUpdateModal(dataupdate)}
                    >
                        <SaveIcon />
                        <Typography>Save</Typography>
                    </Button>
                </Box>


            </Box>
        </Modal>
    );
};

export default ModalUpdate;